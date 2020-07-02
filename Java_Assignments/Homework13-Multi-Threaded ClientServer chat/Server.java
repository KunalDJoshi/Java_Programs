
import java.io.*;
import java.net.*;
import java.util.*;

/**
 *Server class has Server constructor. 
 *@author Kunal Joshi
 *version 1.0
 *@since 2019-12-10
 */
public class Server extends Thread {
    private ServerSocket server;
     List<ChatHandler> clientList;

    /**
    This is the main method which calls Server constructor.   
    * @param Nothing.
    * @return Nothing.
    */	
    public static void main(String[] args) {
        new Server(8888);
    }

    /**
    This is constructor of Server class. 
    */
    public Server(int port) {
        try {
            this.server = new ServerSocket(port);
            System.out.println("Server started!");
            clientList = Collections.synchronizedList(new ArrayList<ChatHandler>());
            this.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                Socket soc = server.accept();
                ChatHandler newClient = new ChatHandler(soc);
                clientList.add(newClient);
                new SendMessage(clientList,soc);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


/**
 *SendMessage class has SendMessage constructor. This class is for broadcasting messages to clients which are connected.
 *@author Kunal Joshi
 *version 1.0
 *@since 2019-12-10
 */
class SendMessage extends Thread {
     List<ChatHandler> clientList;
     BufferedReader br;
     String[] data;
     Socket socket;
     String message;
	  String connect = "Connect";
	  String disconnect = "Disconnect";
     String	chat = "Chat";
	
    /**
    This is constructor of SendMessage class. 
    */	
    public SendMessage(List<ChatHandler> clientList, Socket socket) {
        this.clientList = clientList;
        this.data = null;
        this.start();
        this.socket = socket;
    }


    public void run() {
        try {
            if (clientList.size() > 0) {
                this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                while ((message = br.readLine()) != null) {
                    data = message.split(":");
                    if (data[2].equals(connect)) {
                        for (ChatHandler soc : clientList) {
                            soc.pw.println((data[0] + ":" + data[1] + ":" + chat));
                            Thread.currentThread();
                            Thread.sleep(1 * 500);
                        }


                    }
                    else if (data[2].equals(disconnect))
                    {
                        for (ChatHandler soc : clientList) {
                            soc.pw.println((data[0] + ":is disconnected." + ":" + chat));
                            Thread.currentThread();
                            Thread.sleep(1 * 500);
                        }


                    }
                    else if (data[2].equals(chat))
                    {

                        for (ChatHandler soc : clientList) {
                            soc.pw.println(message);
                            Thread.currentThread();
                            Thread.sleep(1 * 500);
                        }
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/**
 *ChatHandler class has ChatHandler constructor. 
 *@author Kunal Joshi
 *version 1.0
 *@since 2019-12-10
 */
class ChatHandler {
     Socket soc;
     PrintWriter pw;

    /**
    This is constructor of ChatHandler class. 
    */	
    public ChatHandler(Socket soc) {
        this.soc = soc;
        try {
            this.pw = new PrintWriter(soc.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}