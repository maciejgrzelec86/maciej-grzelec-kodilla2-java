package com.kodilla.project1;

import java.awt.*;

public class Square extends Rectangle {
    public Square(boolean playerAorB, int x, int y){
        Board board = new Board();
        setSize(board.BOARD_SIZE/8,board.BOARD_SIZE/8);

    }
}
