package com.kodilla.project1;

import javafx.scene.layout.GridPane;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BoardTestSuite {
    @Test
    public void testProperMove(){
        //Given
        GridPane grid = new GridPane();
        Board board = new Board(grid, null, null);
        board.initBoard();
        //When
        boolean result = board.properMove(2,3,4,5);
        //Then
        assertEquals(false, result);
    }

    //testowac poszczegolne ruchy
    //czy metoda isFinish() zwraca true false
    //robert c. martin clean coder
    //10
}