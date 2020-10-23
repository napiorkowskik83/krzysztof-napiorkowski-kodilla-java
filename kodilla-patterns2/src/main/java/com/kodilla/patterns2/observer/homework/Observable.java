package com.kodilla.patterns2.observer.homework;

public interface Observable {
    void registerObserver(TasksObserver observer);
    void notifyObservers();
    void removeObserver(TasksObserver observer);
}
