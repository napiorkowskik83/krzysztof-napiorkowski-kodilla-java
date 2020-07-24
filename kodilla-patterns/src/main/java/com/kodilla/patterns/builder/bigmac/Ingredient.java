package com.kodilla.patterns.builder.bigmac;

public enum Ingredient {

    LETTUCE, ONION, BECON, PICKLE, CHILI_PEPPERS, MUSHROOMS, SHRIMPS, CHEESE;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
