package com.kodilla.patterns.tasks;

public class TaskFactory {
    public static final String DRIVING = "DRIVING";
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";

    public final Task makeTask(final String taskClass){
        return switch (taskClass){
            case DRIVING -> new DrivingTask("task1","where1","using1");
            case SHOPPING -> new ShoppingTask("task2","product",2);
            case PAINTING -> new PaintingTask("task3","blue","car");
            default -> null;
        };
    }
}
