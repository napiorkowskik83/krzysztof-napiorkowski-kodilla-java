package com.kodilla.patterns.social;

public class FacebookPublisher implements SocialPublisher {

    @Override
    public String share() {
        return "sharing post on Facebook";
    }
}
