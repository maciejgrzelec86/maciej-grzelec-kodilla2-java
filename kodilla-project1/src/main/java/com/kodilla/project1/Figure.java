package com.kodilla.project1;

import javafx.scene.image.Image;

public class Figure {
    private FigureColour colour;
    //private double mouseClickA, mouseClickB;
    //private double oldPositionX, oldPositionY;

    public Image whitePawn = new javafx.scene.image.Image("file:resources/white_pawn_128.png");
    public Image blackPawn = new javafx.scene.image.Image("file:resources/black_pawn_128.png");

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
            return blackPawn; // co tutaj??
        }
    }

    public boolean notNullOrNone(Figure figure) {
        if (figure.getColour()==FigureColour.WHITE || figure.getColour()==FigureColour.BLACK) {
            return true;
        } else {
            return false;
        }
    }

}
