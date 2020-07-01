package com.kodilla.spring.portfolio;

import java.util.stream.Collectors;

public final class Board {
    private final TaskList toDoList;
    private final TaskList inProgressList;
    private final TaskList doneList;

    public Board(final TaskList toDoList, final TaskList inProgressList, final TaskList doneList){
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public void addToDoTask(String task){
        toDoList.addTask(task);
    }

    public void addInProgressTask(String task){
        inProgressList.addTask(task);
    }

    public void addDoneTask(String task){
        doneList.addTask(task);
    }

    public void readTaskLists(){
        String toDo =  toDoList.getTasks()
                .stream()
                .collect(Collectors.joining(", ", "To do: ", ""));
        System.out.println(toDo);

        String inProgress =  inProgressList.getTasks()
                .stream()
                .collect(Collectors.joining(", ", "In progress: ", ""));
        System.out.println(inProgress);

        String done =  doneList.getTasks()
                .stream()
                .collect(Collectors.joining(", ", "Done: ", ""));
        System.out.println(done);
    }
}
