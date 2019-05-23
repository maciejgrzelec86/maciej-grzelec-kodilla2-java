package com.kodilla.project1;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;

public class Checkers extends Application {

    public static final int BOARD_SIZE = 600;
    private final Image imageback = new Image("file:kodilla-project1/src/main/resources/checkers_board.jpg");
    private Board board;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true,
                true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setBackground(background);

        board = new Board(grid);
        board.initBoard();
        board.showBoard();

        Scene scene = new Scene(grid, BOARD_SIZE, BOARD_SIZE);
        //scene.setFill(Color.TRANSPARENT);

        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();

        //System.out.println(board.getFigure(7,7));
        System.out.println(grid.getChildren());
        //System.out.println(grid.getScene());
        //grid.setVisible(true);

    }
}




