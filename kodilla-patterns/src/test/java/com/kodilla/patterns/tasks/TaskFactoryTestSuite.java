package com.kodilla.patterns.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskFactoryTestSuite {
    @Test
    void testFactoryDriving(){
//        given
        TaskFactory factory = new TaskFactory();
//        when
        Task driving = factory.makeTask(TaskFactory.DRIVING);
//        then
        assertEquals("task1",driving.getTaskName());
        assertTrue(driving.isTaskExecuted());
    }
    @Test
    void testFactoryShopping(){
        //        given
        TaskFactory factory = new TaskFactory();
//        when
        Task shopping = factory.makeTask(TaskFactory.SHOPPING);
//        then
        assertEquals("task2",shopping.getTaskName());
        assertFalse(shopping.isTaskExecuted());
    }

    @Test
    void testFactoryPainting(){
//        given
        TaskFactory factory = new TaskFactory();
//        when
        Task painting = factory.makeTask(TaskFactory.PAINTING);
//        then
        assertEquals("task3",painting.getTaskName());
        assertFalse(painting.isTaskExecuted());
    }

}
