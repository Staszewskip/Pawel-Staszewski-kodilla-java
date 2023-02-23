package com.kodilla.patterns2.observer.forum.homework;

import java.util.ArrayList;
import java.util.List;

public class TasksQueue implements ObservableTask {
    private final List<Task> tasks;
    private final List<TaskObserver> mentor;
    private final String studentName;

    public TasksQueue(String studentName) {
        tasks = new ArrayList<>();
        mentor = new ArrayList<>();
        this.studentName = studentName;
    }

    public String addTask(Task task) {
        tasks.add(task);
        return sendInformation();
    }

    @Override
    public void registerMentor(TaskObserver taskObserver,TasksQueue tasksQueue) {
        mentor.add(taskObserver);
        taskObserver.addQueue(tasksQueue);
    }

    @Override
    public void removeMentor(TaskObserver taskObserver) {
        mentor.remove(taskObserver);
    }

    public String sendInformation() {
        return "You have a new task to check";
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<TaskObserver> getMentors() {
        return mentor;
    }
}
