package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task createTask(String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("Buying", "carrot", 3);
            case PAINTING:
                return new PaintingTask("Painting", "beige", "wall");
            case DRIVING:
                return new DrivingTask("Driving", "home", "Jaguar");
            default:
                throw new IllegalArgumentException("Pointed task type do not exist!");
        }
    }
}
