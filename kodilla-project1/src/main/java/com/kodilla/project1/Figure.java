package com.kodilla.project1;

import javafx.scene.image.Image;

public class Figure {
    private FigureColour colour;

    private Image whitePawn = new Image("file:kodilla-project1/src/main/resources/white_pawn_128_tran.png");
    private Image blackPawn = new Image("file:kodilla-project1/src/main/resources/black_pawn_128_tran.png");
    private Image blackQueen = new Image("file:kodilla-project1/src/main/resources/queen_black_trans.png");
    private Image whiteQueen = new Image("file:kodilla-project1/src/main/resources/white_queen.png");

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
}
