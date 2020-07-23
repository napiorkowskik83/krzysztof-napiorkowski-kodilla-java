package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Test
    public void testFactoryShopping() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shopping = factory.createTask(TaskFactory.SHOPPING);
        //Then
        Assert.assertEquals(false, shopping.isTaskExecuted());
        Assert.assertEquals("Buying", shopping.getTaskName());
    }

    @Test
    public void testFactoryPainting() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task painting = factory.createTask(TaskFactory.PAINTING);
        painting.executeTask();
        //Then
        Assert.assertEquals(true, painting.isTaskExecuted());
        Assert.assertEquals("Painting", painting.getTaskName());
    }

    @Test
    public void testFactoryDriving() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task driving = factory.createTask(TaskFactory.DRIVING);
        driving.executeTask();
        //Then
        Assert.assertNotEquals(false, driving.isTaskExecuted());
        Assert.assertEquals("Driving", driving.getTaskName());
    }
}
