package com.kodilla.project1;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class Board {

    public static final int BOARD_SIZE = 500;

    private Image imageback = new Image("file:resources/checkers board.jpg");

    BackgroundSize backgroundSize = new BackgroundSize(100, 100, true,
            true, true, false);

    BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER, backgroundSize);

    Background background = new Background(backgroundImage);

    public Parent createBoard() {
        GridPane layout = new GridPane();
        layout.setBackground(background);
        layout.setPrefSize(BOARD_SIZE, BOARD_SIZE);
        return layout;
    }




}
