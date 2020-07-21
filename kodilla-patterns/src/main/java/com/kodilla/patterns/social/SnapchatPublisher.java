package com.kodilla.patterns.social;

public class SnapchatPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "sharing post on Snapchat";
    }
}
