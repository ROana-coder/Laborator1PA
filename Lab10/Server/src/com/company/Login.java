package com.company;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

public class Login {


    private ArrayList<ClientThread> clients = new ArrayList<>();
    private PrintWriter out;
    private ArrayList<String> friends = new ArrayList<>();
    private ExecutorService pool;

    public Login(ArrayList<ClientThread> clients, PrintWriter out, ExecutorService pool) {
        this.clients = clients;
        this.out = out;
        this.pool = pool;
    }

    public void LoginCommand(String name)
    {
        int log = 0;
        for (ClientThread aClient : clients) {
            if(name.equals(aClient.getName()))
            {
                if(aClient.getConnected() == true)
                {
                    out.println("already logged");
                    log = 1;
                    pool.execute(aClient);

                }
                else {
                    out.println("logged in successfully!");
                    aClient.setConnected(true);
                    pool.execute(aClient);
                    log = 1;
                }
            }
        }

        if (log == 0) out.println("register");
    }

}
