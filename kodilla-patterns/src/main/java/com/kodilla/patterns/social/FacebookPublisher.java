package com.kodilla.patterns.social;

public final class FacebookPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "Post published on Facebook";
    }
}
