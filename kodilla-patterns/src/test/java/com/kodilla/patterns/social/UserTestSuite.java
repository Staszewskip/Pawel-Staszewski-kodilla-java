package com.kodilla.patterns.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
//        given
        User user1 = new YGeneration("user1");
        User user2 = new ZGeneration("user2");
        User user3 = new Millenials("user3");

//        when
        String user1ShouldUse = user1.share();
        System.out.println("User1: " + user1ShouldUse);
        String user2ShouldUse = user2.share();
        System.out.println("User2: " + user2ShouldUse);
        String user3ShouldUse = user3.share();
        System.out.println("User3: " + user3ShouldUse);

//        then
        assertEquals("Post published on Facebook",user1ShouldUse);
        assertEquals("Post published on Snapchat",user2ShouldUse);
        assertEquals("Post published on Twitter",user3ShouldUse);
    }

    @Test
    void testIndividualSharingStrategy() {
//        given
        User user1 = new YGeneration("user1");
//        when
        String user1ShouldUse = user1.share();
        System.out.println("User1: " + user1ShouldUse);
        user1.setSocialPublisher(new SnapchatPublisher());
        user1ShouldUse = user1.share();
        System.out.println("User1: " + user1ShouldUse);
//        then
        assertEquals("Post published on Snapchat",user1ShouldUse);
    }
}