package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {
    public SimpleClient() throws IOException {
        String serverAddress = "localhost"; // The server's IP address
        int PORT = 8100; // The server's port
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader (
                        new InputStreamReader(socket.getInputStream()))
        ) {
            // Send a request to the server
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            // Reading data using readLine
            String request = reader.readLine();
            out.println(request);
            // Wait the response from the server ("Hello World!")
            String response = in.readLine ();
            System.out.println(response);
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}