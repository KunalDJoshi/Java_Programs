
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.*;

/**
 *Client class has Client constructor and it implements GUI interface. 
 *@author Kunal Joshi
 *version 1.0
 *@since 2019-12-10
 */
public class Client extends JFrame {
    private JButton jbConnect;
    private JButton jbDisconnect;
    private JButton jbSend;
    private JPanel jpNorth;
    private JPanel jpSouth;
    private JTextArea jTA;
    private JTextField jTFChat;
    private JScrollPane jScrollPane1;
    private JPanel btnPanel;
    private JTextField jTFUsername;

    Socket soc;
	BufferedReader br;
    PrintWriter pw;
    String username;
    Boolean isConnected = false;


    /**
    This is the main method which calls setVisible() method.   
    * @param Nothing.
    * @return Nothing.
    */	
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
				Client cli = new Client();
				cli.setVisible(true);
            }
        });
    }

    /**
    This is constructor of Client class. 
    */
    public Client() {
        guiScreen();
    }

    /**
    This method is for creating GUI.
    */
    private void guiScreen() {
		
        jpNorth = new JPanel();
        jpSouth = new JPanel();
        btnPanel = new JPanel();
        jScrollPane1 = new JScrollPane(jTA);
        jTA = new JTextArea("");
        jTFChat = new JTextField();
        jTFUsername = new JTextField("Enter Username");
        jbSend = new JButton();
        jbConnect = new JButton();
        jbDisconnect = new JButton();

        this.setLayout(new BorderLayout());
        this.add(jpNorth, BorderLayout.NORTH);
        this.add(jTA, BorderLayout.CENTER);
        this.add(jpSouth, BorderLayout.SOUTH);
        jpNorth.setLayout(new BorderLayout());
        jpSouth.setLayout(new BorderLayout());
		
		//Adding components in jPanel
        jpNorth.add(jbConnect, BorderLayout.WEST);
        jpNorth.add(jTFUsername, BorderLayout.CENTER);
        jpNorth.add(jbDisconnect, BorderLayout.EAST);
        jpSouth.add(jTFChat, BorderLayout.CENTER);
        jpSouth.add(btnPanel, BorderLayout.EAST);
        btnPanel.add(jbSend, BorderLayout.NORTH);
        this.setSize(500, 500);
        this.setTitle("Multi-Threaded Client/Server chat");
        this.setName("client");


        //Adding Buttons
        jbSend.setText("SEND");
        jbConnect.setText("CONNECT");
        jbDisconnect.setText("DISCONNECT");


        //   this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.jbConnect.addActionListener(Client.this::jbConActPer);
        this.jbDisconnect.addActionListener(Client.this::jbDisconActPer);
        this.jbSend.addActionListener(Client.this::jbSendActPer);
    }


    /**
	This method is for making connection with Server through socket. 
	@param ActionEvent e.
   @return Nothing
	*/
    private void jbConActPer(ActionEvent e) {

        if (!this.isConnected) {
            this.username = this.jTFUsername.getText();
            this.jTFUsername.setEditable(false);

            try {
                this.soc = new Socket("localhost", 8888);
                InputStreamReader in = new InputStreamReader(this.soc.getInputStream());
                this.br = new BufferedReader(in);
                this.pw = new PrintWriter(this.soc.getOutputStream(), true);
                this.pw.println(this.username + ":is connected.:Connect");
                this.isConnected = true;

            } catch (Exception ex) {
                this.jTA.append("Server not started! Can't connect. \n");
                this.jTFUsername.setEditable(true);
            }
            this.startThread();
        }
    }


    /**
	This method is for disconnecting connection with Server. 
	jbDisconActPer() calls disconnect()
	@param ActionEvent e.
   @return Nothing
	*/
    private void jbDisconActPer(ActionEvent e) {
        this.sendDisconnect();
        this.disconnect();
    }

    private void disconnect() {
        try {
            this.jTA.append("You are Disconnected.\n");
            this.soc.close();
        } catch (Exception e) {
        }
        this.isConnected = false;
        this.jTFUsername.setEditable(true);

    }

    private void clientDisconnect(String name) {

        this.jTA.append(name + " is now Disconnected.\n");


    }



    /**
	This method sends client disconnection message to Server. 
	@param ActionEvent e.
   @return Nothing
	*/
    private void sendDisconnect() {

        String dis = this.username + ": :Disconnect";
        try 
        {
            this.pw.println(dis);

        } catch (Exception e) {
            this.jTA.append("Disconnect message can't be sent.\n");
        }
    }


    /**
	This method calls run() of ThreadClass. 
	@param ActionEvent e.
   @return Nothing
	*/
    private void startThread() {
        Thread ThreadClass = new Thread(new Client.ThreadClass());
        ThreadClass.start();
    }


    /**
	This method is for sending message to server. 
	@param ActionEvent e.
   @return Nothing
	*/
    private void jbSendActPer(ActionEvent e) {

        String msg = "";
        if (this.jTFChat.getText().equals(msg)) {
            this.jTFChat.setText("");
            this.jTFChat.requestFocus();
        } else {
            try {
                this.pw.println(this.username + ":" + this.jTFChat.getText() + ":" + "Chat");
                this.pw.flush();
            } catch (Exception ex) {
                this.jTA.append("Please first connect! \n");
            }

            this.jTFChat.setText("");
            this.jTFChat.requestFocus();
        }

    }


/**
 *ThreadClass class implements Runnable interface. 
 *@author Kunal Joshi
 *version 1.0
 *@since 2019-12-10
 */
    class ThreadClass implements Runnable {
        public ThreadClass() {
        }

        String connect = "Connect";
        String disconnect = "Disconnect";
        String chat = "Chat";


        public void run() {

            String msg;
            try {
                while ((msg = Client.this.br.readLine()) != null) {
					String[] data = msg.split(":");
					if (data[2].equals(connect)) {
                        Client.this.jTA.removeAll();
						}
					else if	(data[2].equals(disconnect)) {
                        Client.this.clientDisconnect(data[0]);
						}
					else if (data[2].equals(chat)) {
                        Client.this.jTA.append(data[0] + ": " + data[1] + "\n");
                        Client.this.jTA.setCaretPosition(Client.this.jTA.getDocument().getLength());
						}
                }
            } catch (Exception ex) {
            }


        }
    }


}

