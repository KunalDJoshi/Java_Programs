
import java.net.*;
import java.io.*;
public class Server {
    public static void main(String args[]) {
        Server ser = new Server();
        ser.execSer();
    }

    public void execSer() {
        int port = 8888;
        try {
            System.out.println("Starting the server");
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Server waiting for client request");
            Socket soc = ss.accept();
            System.out.println("Client connected");
            BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));


            while (true) {
                String message = br.readLine();
                if (message.equals("quit")) {
                    System.out.println("Closing connection");
                    break;
                } else {
                    System.out.println("Message received from client is: " + message);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}