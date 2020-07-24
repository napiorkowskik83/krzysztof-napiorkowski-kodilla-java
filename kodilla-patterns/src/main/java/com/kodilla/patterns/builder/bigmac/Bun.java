package com.kodilla.patterns.builder.bigmac;

public enum Bun {

    PLAIN, SESAME;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
