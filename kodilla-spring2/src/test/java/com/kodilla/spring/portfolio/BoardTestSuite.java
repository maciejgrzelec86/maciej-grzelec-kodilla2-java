package com.kodilla.spring.portfolio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BoardTestSuite {
    @Test
    public void testExistanceOfBeans(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        //When
        Boolean isToDoList = context.containsBean("toDoList");
        Boolean isInProgressList = context.containsBean("inProgressList");
        Boolean isDoneList = context.containsBean("doneList");
        Boolean isBoard = context.containsBean("board");
        //Then
        System.out.println("Bean isToDoList: " + isToDoList);
        System.out.println("Bean isInProgressList: " + isInProgressList);
        System.out.println("Bean isDoneList: " + isDoneList);
        System.out.println("Bean isBoard: " + isBoard);
    }

    @Test
    public void testTaskAdd(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        //When
        Board board = (Board) context.getBean("board");
        board.getDoneList().getTasks().add("done");
        board.getInProgressList().getTasks().add("in progress");
        board.getToDoList().getTasks().add("to do");
        //Then
        System.out.println(board.getDoneList().getTasks().get(0));
        System.out.println(board.getInProgressList().getTasks().get(0));
        System.out.println(board.getToDoList().getTasks().get(0));
    }
}
