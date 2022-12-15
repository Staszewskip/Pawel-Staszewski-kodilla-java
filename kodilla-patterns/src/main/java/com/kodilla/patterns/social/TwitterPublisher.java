package com.kodilla.patterns.social;

public final class TwitterPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "Post published on Twitter";
    }
}
