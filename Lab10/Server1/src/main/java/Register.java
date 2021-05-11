
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

public class Register {


        private BufferedReader in;
        public PrintWriter out;

        public Register(BufferedReader in, PrintWriter out) {
                this.in = in;
                this.out = out;

        }
        public ArrayList<ClientThread> RegisterCommand(String name, Socket clientSocket, ArrayList<ClientThread> clients, ExecutorService pool) throws IOException {
        // Send the response to the output stream: server → client
        ClientThread newClient = new ClientThread(clientSocket, clients, name, pool);
        clients.add(newClient);
        return clients;
}

}
