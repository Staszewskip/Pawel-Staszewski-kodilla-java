package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testFindByListName() {
//    given
        TaskList taskList = new TaskList(1, "TaskNames", "TasksToDo");
        taskListDao.save(taskList);
//     when
        List<TaskList> foundTasks = taskListDao.findByListName("TaskNames");

//     then
     assertEquals(1,foundTasks.size());
    }

}