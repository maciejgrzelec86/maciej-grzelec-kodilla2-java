package com.kodilla.project1;

import javafx.scene.image.Image;

public class Pawn extends Figure {

    public Pawn(FigureColour colour) {
        super(colour);
    }

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
