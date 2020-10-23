package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class StudentTasks implements Observable {
    private final List<TasksObserver> observers;
    private final List<String> tasks;
    private final String studentName;

    public StudentTasks(String studentName) {
        observers = new ArrayList<>();
        tasks = new ArrayList<>();
        this.studentName = studentName;
    }

    public void addTask(String task) {
        tasks.add(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(TasksObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (TasksObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(TasksObserver observer) {
        observers.remove(observer);
    }

    public List<String> getTasks() {
        return tasks;
    }

    public String getStudentName() {
        return studentName;
    }
}
