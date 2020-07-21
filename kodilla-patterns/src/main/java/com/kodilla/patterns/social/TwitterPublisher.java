package com.kodilla.patterns.social;

public class TwitterPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "sharing post on Twitter";
    }
}
