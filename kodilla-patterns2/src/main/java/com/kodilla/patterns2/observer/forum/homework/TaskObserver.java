package com.kodilla.patterns2.observer.forum.homework;

public interface TaskObserver {

    String approveTheTask(Task task);
    String writeAComment(Task task);
    void addQueue(TasksQueue tasksQueue);
    int countQueues();
}