package com.kodilla.project1;

public enum FigureColour {
    WHITE(-1),
    BLACK(1),
    NONE(0);

    final int moveUpOrDown;

    FigureColour(int moveUpOrDown) {
        this.moveUpOrDown = moveUpOrDown;
    }
}
