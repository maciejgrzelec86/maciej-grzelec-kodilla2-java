package com.kodilla.project1;

import javafx.scene.image.Image;

public class Queen extends Figure {
    private Image blackQueen;
    private Image whiteQueen;

    public Queen(FigureColour colour, Image whiteImage, Image blackImage) {
        super(colour);
        whiteQueen = whiteImage;
        blackQueen = blackImage;
    }

    @Override
    public boolean equals(Object o){
        Queen q = (Queen)o;
        return q.getColour()== getColour();
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
