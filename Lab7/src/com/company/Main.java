package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Token> tokens = new ArrayList<>();
        for (int count = 1; count <= 20; count++) {
            tokens.add(new Token(count));
        }
        Board Board = new Board(tokens);
        List<Player> players = new ArrayList<>();
        Player firstPlayer = new Player("Ionut", Board);
        Player secondPlayer = new Player("Giovanni", Board);
        Player thirdPlayer = new Player("Oana", Board);
        Player forthPlayer = new Player("Dumitrita", Board);
        players.add(firstPlayer);
        players.add(secondPlayer);
        //players.add(thirdPlayer);
        //players.add(forthPlayer);

	Game game = new Game("The first game", 2, players, Board);
    }
}
