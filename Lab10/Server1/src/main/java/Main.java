
import com.sun.net.httpserver.HttpServer;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

//    private static String[] names = {"Ion", "Vasile", "Gheorghe", "Adam"};
//    private static String[] adjs = {"ciobanul", "caprarul", "oierul", "vinovatul", "Moromete"};
    private static final int PORT = 8100;

    private static ArrayList<ClientThread> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(10);


    public static void main(String[] args) throws IOException {

//EventQueue.invokeLater(() -> {
        var ex = new Chart(clients);
        ex.setVisible(true);
        //});
        int port = 4000;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        System.out.println("server started at " + port);
        server.createContext("/", new RootHandler(ex));
        server.createContext("/echoHeader", new EchoHeaderHandler());
        server.createContext("/echoGet", new EchoGetHandler());
        server.createContext("/echoPost", new EchoPostHandler());
        server.setExecutor(null);
        server.start();

        ServerSocket listener = new ServerSocket(PORT);

        while (true) {
            System.out.println("[SERVER] Waiting for client connection...");
            Socket client = listener.accept();
            System.out.println("[SERVER] Connected to a client!");

            ClientThread clientThread = new ClientThread(client, clients, "Oana", pool);
            clients.add(clientThread);

            ClientThread clientThread1 = new ClientThread(client, clients, "Ioana", pool);
            clients.add(clientThread1);

            ClientThread clientThread2 = new ClientThread(client, clients, "Ana", pool);
            clients.add(clientThread2);

            ClientThread clientThread3 = new ClientThread(client, clients, "Maria", pool);
            clients.add(clientThread3);

            pool.execute(clientThread);
//            pool.execute(clientThread1);
//            pool.execute(clientThread2);
//            pool.execute(clientThread3);


        }

    }


}

