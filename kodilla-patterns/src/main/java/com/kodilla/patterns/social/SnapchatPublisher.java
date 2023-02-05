package com.kodilla.patterns.social;

public final class SnapchatPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "Post published on Snapchat";
    }
}
