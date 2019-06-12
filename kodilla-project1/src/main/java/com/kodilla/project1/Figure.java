package com.kodilla.project1;

import javafx.scene.image.Image;

public class Figure {
    private FigureColour colour;

    public Figure(FigureColour colour) {
        this.colour = colour;
    }

    public FigureColour getColour() {
        return colour;
    }

    public Image getImage() {
        return null;
    }
}
