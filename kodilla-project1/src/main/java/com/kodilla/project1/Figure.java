package com.kodilla.project1;

import javafx.scene.image.Image;

public class Figure {
    private FigureColour colour;
    //private double mouseClickA, mouseClickB;
    //private double oldPositionX, oldPositionY;

    private Image whitePawn = new Image("file:kodilla-project1/src/main/resources/white_pawn_128.png");
    private Image blackPawn = new Image("file:kodilla-project1/src/main/resources/black_pawn_128.png");

    public Figure(FigureColour colour) {
        this.colour = colour;
    }

    public FigureColour getColour() {
        return colour;
    }

    public Image getImage() {
        if (getColour()==FigureColour.WHITE){
            return whitePawn;
        } else if (getColour()==FigureColour.BLACK) {
            return blackPawn;
        } else {
            return null;
        }
    }

    public boolean notNullOrNotNone(Figure figure) {
        if (figure.getColour()==FigureColour.WHITE || figure.getColour()==FigureColour.BLACK) {
            return true;
        } else {
            return false;
        }
    }

}
