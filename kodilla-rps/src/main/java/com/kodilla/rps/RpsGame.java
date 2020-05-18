package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RpsGame {
    Scanner sc = new Scanner(System.in);
    List<String> options = new ArrayList<String>();
    List<String> moves = new ArrayList<String>();
    int maxWins;
    int roundNo;
    int choiceInt;
    int computerMoveInt;
    Player player;
    Player computer;
    String currentPlayerName = "";
    boolean end;
    Random randomGenerator = new Random();

    public void setUpGame() {
        options.add("1");
        options.add("2");
        options.add("3");
        options.add("x");
        options.add("n");
        moves.add("ROCK");
        moves.add("PAPER");
        moves.add("SCISSORS");
        System.out.println("Welcome to 'ROCK PAPER SCISSORS' game.");
        while ("".equals(currentPlayerName)) {
            System.out.println("Please enter your name:");
            currentPlayerName = sc.next();
        }
    }

    public void startNewGame() {
        player = new Player(currentPlayerName);
        computer = new Player("Computer");
        System.out.println("\n" + player.getName() + ", let's start a new battle!");
        try {
            System.out.println("Please enter maximum number of wins:");
            maxWins = sc.nextInt();
        } catch (Exception e) {
            System.out.println("You entered not a proper data!");
            System.out.println("Game assumed maximum number of wins: 3\n");
            String empty = sc.next();
            maxWins = 3;
        }

        boolean continueGame = true;
        while (player.getWinsNumber() < maxWins && computer.getWinsNumber() < maxWins && continueGame) {
            continueGame = playNextRound();
        }
        if (continueGame) {
            System.out.println("That was the final results!");
            if (player.getWinsNumber() > computer.getWinsNumber()) {
                System.out.println("You won the game " + player.getName() + "! Congratulations!");
            } else {
                System.out.println("You were brave but... maybe next time... :)");
            }
        }

        roundNo = 0;
    }

    public boolean playNextRound() {
        String choice = "";
        while (!options.contains(choice)) {
            System.out.println("Please choose option:");
            System.out.println("1 - play ROCK");
            System.out.println("2 - play PAPER");
            System.out.println("3 - play SCISSORS");
            System.out.println("x - end game");
            System.out.println("n - new game");
            choice = sc.next();
        }
        String computerMove = options.get(randomGenerator.nextInt(3));

        if ("1".equals(choice) || "2".equals(choice) || "3".equals(choice)) {
            choiceInt = Integer.parseInt(choice);
            computerMoveInt = Integer.parseInt(computerMove);
            checkWinner(choiceInt, computerMoveInt);
            roundNo++;
            System.out.println("\nResult after round #" + roundNo + " :");
            System.out.println("You: " + player.getWinsNumber() + " wins");
            System.out.println("Computer: " + computer.getWinsNumber() + " wins\n");
        } else if ("n".equals(choice)) {
            System.out.println("Do you really want to finish current game?");
            System.out.println("Type 'y' to confirm");
            String confirmation = sc.next();
            if ("y".equals(confirmation)) {
                return false;
            }
        } else if ("x".equals(choice)) {
            System.out.println("Do you really want to end the game?");
            System.out.println("Type 'y' to confirm");
            String confirmation = sc.next();
            if ("y".equals(confirmation)) {
                this.end = true;
                return false;
            }
        }
        return true;
    }

    public void checkWinner(int userMoveInt, int computerMoveInt) {
        if (1 == userMoveInt && 2 == computerMoveInt) {
            System.out.println("Your move: " + moves.get(userMoveInt - 1));
            System.out.println("Computer's move: " + moves.get(computerMoveInt - 1));
            System.out.println(moves.get(computerMoveInt - 1) + " covers " + moves.get(userMoveInt - 1));
            System.out.println("Computer won this round!");
            computer.addWin();
        } else if (1 == userMoveInt && 3 == computerMoveInt) {
            System.out.println("Your move: " + moves.get(userMoveInt - 1));
            System.out.println("Computer's move: " + moves.get(computerMoveInt - 1));
            System.out.println(moves.get(userMoveInt - 1) + " crushes " + moves.get(computerMoveInt - 1));
            System.out.println("You won this round!");
            player.addWin();
        } else if (2 == userMoveInt && 1 == computerMoveInt) {
            System.out.println("Your move: " + moves.get(userMoveInt - 1));
            System.out.println("Computer's move: " + moves.get(computerMoveInt - 1));
            System.out.println(moves.get(userMoveInt - 1) + " covers " + moves.get(computerMoveInt - 1));
            System.out.println("You won this round!");
            player.addWin();
        } else if (2 == userMoveInt && 3 == computerMoveInt) {
            System.out.println("Your move: " + moves.get(userMoveInt - 1));
            System.out.println("Computer's move: " + moves.get(computerMoveInt - 1));
            System.out.println(moves.get(computerMoveInt - 1) + " cut " + moves.get(userMoveInt - 1));
            System.out.println("Computer won this round!");
            computer.addWin();
        } else if (3 == userMoveInt && 1 == computerMoveInt) {
            System.out.println("Your move: " + moves.get(userMoveInt - 1));
            System.out.println("Computer's move: " + moves.get(computerMoveInt - 1));
            System.out.println(moves.get(computerMoveInt - 1) + " breaks " + moves.get(userMoveInt - 1));
            System.out.println("Computer won this round!");
            computer.addWin();
        } else if (3 == userMoveInt && 2 == computerMoveInt) {
            System.out.println("Your move: " + moves.get(userMoveInt - 1));
            System.out.println("Computer's move: " + moves.get(computerMoveInt - 1));
            System.out.println(moves.get(computerMoveInt - 1) + " cut " + moves.get(userMoveInt - 1));
            System.out.println("You won this round!");
            player.addWin();
        } else {
            if (1 == userMoveInt) {
                System.out.println("Your and computer's move: " + moves.get(userMoveInt - 1));
            } else if (2 == userMoveInt) {
                System.out.println("Your and computer's move: " + moves.get(userMoveInt - 1));
            } else if (3 == userMoveInt) {
                System.out.println("Your and computer's move: " + moves.get(userMoveInt - 1));
            }
            System.out.println("No winner in this round!");
        }
    }

    public boolean isEnd() {
        return end;
    }
}
