
import java.util.*;
import java.net.*;
import java.io.*;
public class Client {
    public static void main(String args[]) {
        Client cli = new Client();
        cli.execute();
    }

    public void execute() {
        String ip = "localhost";
        int port = 8888;
        try {
            Scanner scan = new Scanner(System.in);
            Socket soc = new Socket(ip, port);

            PrintWriter pw = new PrintWriter(new OutputStreamWriter(soc.getOutputStream()));


            while (true) {
                System.out.println("Enter the message:");
                String msg = scan.nextLine();
                if (msg.equalsIgnoreCase("quit")) {
                    pw.println("quit");
                    pw.flush();
                    pw.close();
                    break;
                } else {
                    pw.println(msg);
                    pw.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}