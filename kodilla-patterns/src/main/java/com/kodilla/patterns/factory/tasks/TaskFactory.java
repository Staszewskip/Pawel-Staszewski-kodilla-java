package com.kodilla.patterns.factory.tasks;

import java.util.HashMap;
import java.util.Map;

public class TaskFactory {
    public static final String DRIVING = "DRIVING";
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    private final Map<Task, Boolean> tasks = new HashMap<>();

    public final Task makeTask(final String taskClass){
        return switch (taskClass){
            case DRIVING -> new DrivingTask("task1","where1","using1");
            case SHOPPING -> new ShoppingTask("task2","product",2);
            case PAINTING -> new PaintingTask("task3","blue","car");
            default -> null;
        };
    }
    public Map<Task, Boolean> putTaskInMap(Task task) {
        task.executeTask();
        Boolean isExecuted = task.isTaskExecuted();
        tasks.put(task, isExecuted);
        return tasks;
    }
}
