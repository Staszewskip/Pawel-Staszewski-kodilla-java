package com.kodilla.patterns.tasks;

import com.kodilla.patterns.factory.tasks.Task;
import com.kodilla.patterns.factory.tasks.TaskFactory;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TaskFactoryTestSuite {
    @Test
    void testFactoryDriving(){
//        given
        TaskFactory factory = new TaskFactory();
//        when
        Task driving = factory.makeTask(TaskFactory.DRIVING);
        driving.executeTask();
        boolean isExecuted = driving.isTaskExecuted();
//        then
        assertEquals("DRIVING",driving.getTaskName());
        assertTrue(isExecuted);
    }
    @Test
    void testFactoryShopping(){
        //        given
        TaskFactory factory = new TaskFactory();
//        when
        Task shopping = factory.makeTask(TaskFactory.SHOPPING);
        shopping.executeTask();
        boolean isExecuted = shopping.isTaskExecuted();
//        then
        assertEquals("SHOPPING",shopping.getTaskName());
        assertTrue(isExecuted);
    }

    @Test
    void testFactoryPainting(){
//        given
        TaskFactory factory = new TaskFactory();
//        when
        Task painting = factory.makeTask(TaskFactory.PAINTING);
        painting.executeTask();
        boolean isExecuted = painting.isTaskExecuted();
//        then
        assertEquals("PAINTING",painting.getTaskName());
        assertTrue(isExecuted);
    }
    @Test
    void testFactoryPaintingNotExecuted(){
//        given
        TaskFactory factory = new TaskFactory();
//        when
        Task painting = factory.makeTask(TaskFactory.PAINTING);
        boolean isExecuted = painting.isTaskExecuted();
//        then
        assertEquals("PAINTING",painting.getTaskName());
        assertFalse(isExecuted);
    }

}
