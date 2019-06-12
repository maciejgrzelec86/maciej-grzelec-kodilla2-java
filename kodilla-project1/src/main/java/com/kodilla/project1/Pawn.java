package com.kodilla.project1;

import javafx.scene.image.Image;

public class Pawn extends Figure {
    private Image whitePawn;
    private Image blackPawn;

    public Pawn(FigureColour colour, Image whiteImage, Image blackImage) {
        super(colour);
        whitePawn = whiteImage;
        blackPawn = blackImage;
    }
    @Override
    public Image getImage() {
        if (getColour()==FigureColour.WHITE){
            return whitePawn;
        } else if (getColour()==FigureColour.BLACK) {
            return blackPawn;
        } else {
            return null;
        }
    }
}
