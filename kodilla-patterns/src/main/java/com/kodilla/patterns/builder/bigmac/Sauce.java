package com.kodilla.patterns.builder.bigmac;

public enum Sauce {
    STANDARD, THOUSAND_ISLAND, BARBECUE;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
