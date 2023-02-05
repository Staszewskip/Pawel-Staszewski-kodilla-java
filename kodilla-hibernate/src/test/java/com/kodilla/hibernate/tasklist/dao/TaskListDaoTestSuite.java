package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.TaskList;
import com.kodilla.hibernate.task.dao.TaskListDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String LISTNAME = "Task Name";
    private static final String DESCRIPTION = "Task to do";

    @Test
    void testFindByListName() {
//    given
        TaskList taskList = new TaskList(LISTNAME,DESCRIPTION);
        taskListDao.save(taskList);
        String listName = taskList.getListName();
//     when
        List<TaskList> foundTasks = taskListDao.findByListName(listName);

//     then
     assertEquals(1,foundTasks.size());

     //CleanUp
        int id = foundTasks.get(0).getId();
        taskListDao.deleteById(id);
    }
}