package com.kodilla.patterns.social;

public sealed interface SocialPublisher
        permits FacebookPublisher, SnapchatPublisher, TwitterPublisher {
    String share();
}
