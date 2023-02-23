package com.kodilla.patterns2.observer.forum.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TasksQueueTestSuite {
    @Test
    public void RegisterMentorTest(){
        //Given
        TasksQueue tasksQueue1 = new TasksQueue("Paweł Staszewski");
        TasksQueue tasksQueue2 = new TasksQueue("Piotr Nowak");
        TasksQueue tasksQueue3 = new TasksQueue("Marcin Sowa");

        TaskObserver hubertRosinski = new Mentor("Hubert Rosiński");
        TaskObserver janKowalski = new Mentor("Jan Kowalski");

        //When
        tasksQueue1.registerMentor(hubertRosinski, tasksQueue1);
        tasksQueue2.registerMentor(hubertRosinski, tasksQueue2);
        tasksQueue3.registerMentor(janKowalski, tasksQueue3);

        //Then
        assertEquals(2, hubertRosinski.countQueues());
        assertEquals(1, janKowalski.countQueues());
    }
}