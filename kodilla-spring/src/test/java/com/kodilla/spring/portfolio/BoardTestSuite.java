package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTestSuite {
    @Test
    void testTaskAdd() {
//      given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
//      when
        List<String> toDoList = board.getToDoList().getTasksList();
        toDoList.add("task1");

        List<String> inProgressList = board.getInProgressList().getTasksList();
        inProgressList.add("task2");

        List<String> doneList = board.getDoneList().getTasksList();
        doneList.add("task3");

//      then
        assertEquals("task1", toDoList.get(0));
        assertEquals("task2", inProgressList.get(0));
        assertEquals("task3", doneList.get(0));
        System.out.println(board.showTheBoard());
    }
}