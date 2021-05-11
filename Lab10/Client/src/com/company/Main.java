package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8100;

    public static void main(String[] args) throws IOException {
        try(Socket clientSocket = new Socket(SERVER_IP, SERVER_PORT);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true) ) {


            while (true) {
                System.out.println("> ");
                String command = keyboard.readLine();
                if (command.equals("exit")) break;
                else if (command.startsWith("login")) {
                    ServerConnection serverConnection = new ServerConnection(clientSocket);
                    new Thread(serverConnection).start();
                }
                out.println(command);
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}
