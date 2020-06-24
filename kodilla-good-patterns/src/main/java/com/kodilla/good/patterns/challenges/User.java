package com.kodilla.good.patterns.challenges;

public class User {
    String firstName;
    String surname;

    public User(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return firstName + " " + surname;
    }
}
