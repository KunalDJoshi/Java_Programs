import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient extends JFrame {
    private JButton bt_Connect;
    private JButton bt_Disconnect;
    private JButton bt_Send;
    private JButton bt_Test;
    private JPanel pnl_North;
    private JPanel pnl_South;
    private JTextArea ta_Chat;

    private JTextField tf_Chat;

    private JScrollPane jScrollPane1;
    private JPanel pnl_Btn;
    private JTextField tf_Username;

    String username;
    Boolean isConnected = false;
    Socket s;
    BufferedReader reader;
    PrintWriter writer;


    public ChatClient() {
        initComponents();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new ChatClient()).setVisible(true);
            }
        });
    }


    private void initComponents() {


        pnl_North = new JPanel();
        pnl_South = new JPanel();
        pnl_Btn = new JPanel();
        jScrollPane1 = new JScrollPane(ta_Chat);
        ta_Chat = new JTextArea("");
        tf_Chat = new JTextField();
        tf_Username = new JTextField("Enter Username here");
        bt_Send = new JButton();
        bt_Test = new JButton();
        bt_Connect = new JButton();
        bt_Disconnect = new JButton();

        this.setLayout(new BorderLayout());
        this.add(pnl_North, BorderLayout.NORTH);
        this.add(ta_Chat, BorderLayout.CENTER);
        this.add(pnl_South, BorderLayout.SOUTH);
        pnl_North.setLayout(new BorderLayout());
        pnl_South.setLayout(new BorderLayout());
        pnl_North.add(bt_Connect, BorderLayout.EAST);
        pnl_North.add(tf_Username, BorderLayout.CENTER);
        pnl_North.add(bt_Disconnect, BorderLayout.WEST);
        pnl_South.add(tf_Chat, BorderLayout.CENTER);
        pnl_South.add(pnl_Btn, BorderLayout.EAST);
        pnl_Btn.add(bt_Send, BorderLayout.NORTH);
        pnl_Btn.add(bt_Test, BorderLayout.SOUTH);
        this.setSize(400, 400);
        this.setTitle("Client Chat");
        this.setName("client");


        //Buttons
        bt_Send.setText("SEND");


        bt_Test.setText("TEST");


        bt_Connect.setText("CONNECT");


        bt_Disconnect.setText("DISCONNECT");


        //   this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.bt_Connect.addActionListener(ChatClient.this::bt_ConnectActionPerformed);
        this.bt_Disconnect.addActionListener(ChatClient.this::bt_DisconnectActionPerformed);
        this.bt_Send.addActionListener(ChatClient.this::bt_SendActionPerformed);
        this.bt_Test.addActionListener(ChatClient.this::bt_SendActionPerformed);
    }

    private void bt_ConnectActionPerformed(ActionEvent e) {

        if (!this.isConnected) {
            this.username = this.tf_Username.getText();
            this.tf_Username.setEditable(false);


            try {

                this.s = new Socket("localhost", 12345);
                InputStreamReader in = new InputStreamReader(this.s.getInputStream());
                this.reader = new BufferedReader(in);
                this.writer = new PrintWriter(this.s.getOutputStream(), true);
                this.writer.println(this.username + ":has connected.:Connect");
                this.isConnected = true;

            } catch (Exception ex) {
                this.ta_Chat.append("Cannot Connect! Try Again. \n");
                this.tf_Username.setEditable(true);
            }
            this.ListenThread();
        }
    }

    private void bt_DisconnectActionPerformed(ActionEvent e) {
        this.sendDisconnect();
        this.disconnect();
    }

    private void disconnect() {
        try {
            this.ta_Chat.append("Disconnected.\n");
            this.s.close();
        } catch (Exception e) {
            this.ta_Chat.append("Failed to disconnect. \n");
        }
        this.isConnected = false;
        this.tf_Username.setEditable(true);

    }

    private void clientRemove(String name) {

        this.ta_Chat.append(name + " is now offline.\n");


    }


    private void sendDisconnect() {

        String dis = this.username + ": :Disconnect";


        try {
            this.writer.println(dis);

        } catch (Exception e) {
            this.ta_Chat.append("Could not send Disconnect message.\n");
        }
    }

    private void ListenThread() {
        Thread InnerThread = new Thread(new ChatClient.InnerThread());
        InnerThread.start();
    }

    private void bt_SendActionPerformed(ActionEvent e) {

        String msg = "";
        if (this.tf_Chat.getText().equals(msg)) {
            this.tf_Chat.setText("");
            this.tf_Chat.requestFocus();
        } else {
            try {
                this.writer.println(this.username + ":" + this.tf_Chat.getText() + ":" + "Chat");
                this.writer.flush();
            } catch (Exception ex) {
                this.ta_Chat.append("Message was not sent. \n");
            }

            this.tf_Chat.setText("");
            this.tf_Chat.requestFocus();
        }

    }

    class InnerThread implements Runnable {
        public InnerThread() {
        }

        String connect = "Connect";
        String disconnect = "Disconnect";
        String chat = "Chat";

        @Override
        public void run() {

            String msg;
            try {
                while ((msg = ChatClient.this.reader.readLine()) != null) {
                    String[] data = msg.split(":");
                    if (data[2].equals(chat)) {
                        ChatClient.this.ta_Chat.append(data[0] + ": " + data[1] + "\n");
                        ChatClient.this.ta_Chat.setCaretPosition(ChatClient.this.ta_Chat.getDocument().getLength());
                    } else if (data[2].equals(connect)) {
                        ChatClient.this.ta_Chat.removeAll();

                    } else if (data[2].equals(disconnect)) {
                        ChatClient.this.clientRemove(data[0]);
                    }
                }
            } catch (Exception ex) {
            }


        }
    }


}

