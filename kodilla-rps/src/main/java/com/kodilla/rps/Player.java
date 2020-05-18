package com.kodilla.rps;

public class Player {
    String name;
    int winsNumber = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getWinsNumber() {
        return winsNumber;
    }

    public void addWin() {
        winsNumber++;
    }

}
