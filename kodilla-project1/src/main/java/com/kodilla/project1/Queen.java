package com.kodilla.project1;

import javafx.scene.image.Image;

public class Queen extends Figure {
    private Image blackQueen = new Image("file:kodilla-project1/src/main/resources/queen_black_trans.png");
    private Image whiteQueen = new Image("file:kodilla-project1/src/main/resources/white_queen.png");

    public Queen(FigureColour colour) {
        super(colour);
    }

    @Override
    public Image getImage() {
        if (getColour()==FigureColour.WHITE){
            return whiteQueen;
        } else if (getColour()==FigureColour.BLACK) {
            return blackQueen;
        } else {
            return null;
        }
    }
}
