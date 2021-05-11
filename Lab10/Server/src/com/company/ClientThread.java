

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class ClientThread implements Runnable {

    public void setClient(Socket client) {
        this.client = client;
    }

    private Socket client;
    private BufferedReader in;
    public PrintWriter out;
    private ArrayList<ClientThread> clients;
    private ExecutorService pool;
    private ArrayList<String> friends = new ArrayList<>();

    public String getName() {
        return name;
    }

    private String name;

    public Boolean getConnected() {
        return connected;
    }

    public void setConnected(Boolean connected) {
        this.connected = connected;
    }

    private Boolean connected;

    public ClientThread(Socket clientSocket, ArrayList<ClientThread> clients, String name, ExecutorService pool) throws IOException {
        this.client = clientSocket;
        this.clients = clients;
        this.name = name;
        this.pool = pool;
        friends.add("Oana");
        this.connected = false;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String request = in.readLine();
                out.println("I received the request: " + request);
                if (request.startsWith("send")) {
                    int firstSpace = request.indexOf(" ");
                    Send send = new Send(request.substring(firstSpace+1),out, clients);
                    if (firstSpace != -1) {
                        send.outToAll(request.substring(firstSpace+1), name, friends);
                    }
                    else out.println("No message to send");
                }
                else if (request.startsWith("stop")) {
                    client.close();
                    System.out.println("Server stopped");
                    break;
                }
                else if(request.startsWith("login"))
                {
                    Login login = new Login(clients, out, pool);
                    int firstSpace = request.indexOf(" ");
                    login.LoginCommand(request.substring(firstSpace+1) );
                }
                else if(request.startsWith("register"))
                {
                    Register register = new Register(in, out);
                    int firstSpace = request.indexOf(" ");

                    if (firstSpace != -1) {
                        register.RegisterCommand( request.substring(firstSpace+1), client, clients, pool);
                        out.println("Registered!");
                    }
                    else out.println("register with a name");

                }
                else if (request.equals("online")) {
                    for (ClientThread aClient : clients) {
                        if(friends.contains(aClient.getName()))
                        out.println(aClient.getName());
                    }
                }
                else if (request.startsWith("friend"))
                {
                    String[] names = request.split(" ");
                    for (String name : names)
                    {
                        friends.add(name);
                    }
                }
                else {
                    out.println("enter a valid command");
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            out.close();
            System.out.println("Closed");
            try {
                in.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}


