package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.awt.*;
import javax.swing.*;

public class Main {

//    private static String[] names = {"Ion", "Vasile", "Gheorghe", "Adam"};
//    private static String[] adjs = {"ciobanul", "caprarul", "oierul", "vinovatul", "Moromete"};
    private static final int PORT = 8100;

    private static ArrayList<ClientThread> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(10);

    private static void createWindow()
        {
            JFrame frame = new JFrame("Simple GUI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel textLabel = new JLabel("I'm a label in the window",SwingConstants.CENTER); textLabel.setPreferredSize(new Dimension(300, 100));
            frame.getContentPane().add(textLabel, BorderLayout.CENTER);
            frame.setLocationRelativeTo(null);
            frame.pack();
            frame.setVisible(true);
        }

    public static void main(String[] args) throws IOException {

        ServerSocket listener = new ServerSocket(PORT);
        createWindow();
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

