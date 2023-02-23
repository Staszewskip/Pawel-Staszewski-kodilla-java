package com.kodilla.patterns2.observer.forum.homework;

public interface ObservableTask {
    String addTask(Task task);
    void registerMentor(TaskObserver taskObserver,TasksQueue tasksQueue);
    void removeMentor(TaskObserver taskObserver);
}
