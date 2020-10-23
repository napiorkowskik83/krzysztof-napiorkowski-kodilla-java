package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class TasksObserverTest {

    @Test
    public void testUpdate() {
        //Given
        StudentTasks joeTasks = new StudentTasks("Joe");
        StudentTasks kateTasks = new StudentTasks("Kate");
        StudentTasks janeTasks = new StudentTasks("Jane");
        StudentTasks alTasks = new StudentTasks("Al");
        Mentor nick = new Mentor("Nick");
        Mentor leo = new Mentor("Leo");
        joeTasks.registerObserver(nick);
        kateTasks.registerObserver(nick);
        janeTasks.registerObserver(nick);
        janeTasks.registerObserver(leo);
        alTasks.registerObserver(leo);
        //When
        joeTasks.addTask("Joe's task1");
        joeTasks.addTask("Joe's task2");
        kateTasks.addTask("Kate's task1");
        janeTasks.addTask("Jane's task1");
        janeTasks.addTask("Jane's task2");
        alTasks.addTask("Al's task1");

        assertEquals(5, nick.getUpdateCount());
        assertEquals(3, leo.getUpdateCount());
    }
}