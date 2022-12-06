package com.kodilla.spring.forum;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class ForumUserTestSuite {
    @Test
    void testGetUsername(){
//        given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        ForumUser forumUser = context.getBean(ForumUser.class);

//        when
        String name = forumUser.getUsername();
//        then
        assertEquals("John Smith", name);
    }

}