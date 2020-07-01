package com.kodilla.spring.portfolio;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {

    @Test
    public void testTaskAdd(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.addToDoTask("Buy a bread");
        board.addInProgressTask("Clean kitchen");
        board.addInProgressTask("Write a letter");
        board.addDoneTask("Pick up son from school");
        //Then
        board.readTaskLists();
    }
}
