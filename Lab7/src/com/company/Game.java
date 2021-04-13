package com.company;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.*;

/*
 * The game will have a title and a number of players. A list filled with tokens will be created,
 * the the board will be created, containing that list. There will be two Runnable objects containing each player.
 * The first player will start its own thread and randomly extract tokens from the list, after a waiting period of time,
 * the second player will start its thread, doing the same thing.
 * */

public class Game {

    private Thread thread;
    private List<Player> players = new ArrayList<>();
    private volatile boolean running = false;
    private String title;
    private int numberOfPlayers;
    private Board board;

    public Game(String title, int numberOfPlayers,List<Player> play, Board board) throws InterruptedException {
        this.title = title;
        this.numberOfPlayers = numberOfPlayers;
        this.players = play;
        Board firstBoard = board;

       //System.out.println(players.toString());

        try {
            synchronized (this) {
                while (firstBoard.getTokens().size() > 0) {

                    for (Player actualPlayer : players) {
                        new Thread(actualPlayer).start();
                    }
                    for (Player actualPlayer : players) {
                        new Thread(actualPlayer).run();
                    }
//                    new Thread(firstPlayer).wait(100);
//                    new Thread(secondPlayer).wait(100);
                    System.out.println("The game is on");
                }
            }

        } catch (Exception exception) {
            System.out.println("Nope, game");
        }

    }
}