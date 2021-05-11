package com.company;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Send {
    private PrintWriter out;
    private String message;
    private List<ClientThread> clients;

    public Send(String message, PrintWriter out, List<ClientThread> clients)
    {
        this.message = message;
        this.out = out;
        this.clients = clients;
    }

    void outToAll(String message, String name, ArrayList<String> friends)
    {
        for (ClientThread aClient : clients) {
            if(friends.contains(aClient.getName()))
            {
                aClient.out.println("message from " + name);
                aClient.out.println(message);
            }
        }
    }
}
