package com.kodilla.patterns2.observer.forum.homework;

import java.util.ArrayList;
import java.util.List;

public class Mentor implements TaskObserver {
    private final String name;
    private final List<TasksQueue> queues;
    private int queuesQuantity;

    public Mentor(String name) {
        this.name = name;
        queues = new ArrayList<>();
    }

    @Override
    public String approveTheTask(Task task) {
        return "your task " + task.getName() + "has been accepted";
    }

    @Override
    public String writeAComment(Task task) {
        return "Comment to task " + task.getName();
    }

    public String getName() {
        return name;
    }

    public void addQueue(TasksQueue tasksQueue) {
        queues.add(tasksQueue);
    }

    public int countQueues() {
        return queuesQuantity = getQueues().size();
    }

    public List<TasksQueue> getQueues() {
        return queues;
    }

    public int getQueuesQuantity() {
        return queuesQuantity;
    }
}
