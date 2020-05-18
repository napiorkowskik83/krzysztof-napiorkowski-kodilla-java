package com.kodilla.rps;


public class RpsRunner {
    public static void main(String[] args) {
        RpslsGame game = new RpslsGame();
        game.setUpGame();
        boolean end = false;

        while (!end) {
            game.startNewGame();
            end = game.isEnd();
        }
    }
}
