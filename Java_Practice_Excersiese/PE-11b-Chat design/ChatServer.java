import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer extends Thread {
    private ServerSocket server;
    protected List<ClientHandler> clients;

    public static void main(String[] args) {
        new ChatServer(12345);
    }

    public ChatServer(int port) {
        try {
            this.server = new ServerSocket(port);
            System.out.println("New server initialized!");
            clients = Collections
                    .synchronizedList(new ArrayList<ClientHandler>());
            this.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket client = server.accept();
                System.out.println(client.getInetAddress().getHostName()
                        + " connected");
                ClientHandler newClient = new ClientHandler(client);
                clients.add(newClient);
                new SendMessage(clients,client);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class SendMessage extends Thread {
    protected List<ClientHandler> clients;
    protected BufferedReader br;

    protected String[] data;
    protected Socket socket;
    String message, connect = "Connect", disconnect = "Disconnect", chat = "Chat";
    public SendMessage(List<ClientHandler> clients, Socket socket) {
        this.clients = clients;
        this.data = null;

        this.start();
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            if (clients.size() > 0) {
                this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                while ((message = br.readLine()) != null) {
                    data = message.split(":");
                    if (data[2].equals(connect)) {
                        for (ClientHandler client : clients) {
                            client.out.println((data[0] + ":" + data[1] + ":" + chat));

                            Thread.currentThread();
                            Thread.sleep(1 * 1000);
                        }


                    }
                    else if (data[2].equals(disconnect))
                    {
                        for (ClientHandler client : clients) {
                            client.out.println((data[0] + ":has disconnected." + ":" + chat));

                            Thread.currentThread();
                            Thread.sleep(1 * 1000);
                        }


                    }
                    else if (data[2].equals(chat))
                    {

                        for (ClientHandler client : clients) {
                            client.out.println(message);

                            Thread.currentThread();
                            Thread.sleep(1 * 1000);
                        }
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class ClientHandler {
    protected Socket client;
    protected PrintWriter out;

    public ClientHandler(Socket client) {
        this.client = client;
        try {
            this.out = new PrintWriter(client.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}