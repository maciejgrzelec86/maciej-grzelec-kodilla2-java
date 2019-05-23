package com.kodilla.project1;

import javafx.scene.image.Image;

public class Queen extends Figure {
    public Queen(FigureColour colour) {
        super(colour);
    }

    //do podmiany image pawn na queen jeszcze
    @Override
    public Image getImage() {
        if (getColour() == FigureColour.WHITE) {
            return whitePawn;
        } else {
            //else if (getColour() == FigureColour.BLACK) ... else
            return blackPawn;
        }
    }
}
