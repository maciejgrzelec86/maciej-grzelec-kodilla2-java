package com.kodilla.project1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Checkers extends Application {

    private Image whitePawn = new Image("file:kodilla-project1/src/main/resources/white_pawn_128_tran.png");
    private Image blackPawn = new Image("file:kodilla-project1/src/main/resources/black_pawn_128_tran.png");
    public static final int BOARD_SIZE = 650;
    public static final int ROW_COL_CONSTRAINTS = BOARD_SIZE / 8;
    private Image imageback = new Image("file:kodilla-project1/src/main/resources/checkers_board.jpg");
    private Board board;
    private boolean firstClick = true;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(BOARD_SIZE, BOARD_SIZE, false,
                false, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();

        for (int i = 0; i < 8; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(ROW_COL_CONSTRAINTS));
        }

        for (int i = 0; i < 8; i++) {
            grid.getRowConstraints().add(new RowConstraints(ROW_COL_CONSTRAINTS));
        }

        grid.setAlignment(Pos.CENTER);
        grid.setBackground(background);

        grid.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            int col = (int) e.getX() / ROW_COL_CONSTRAINTS;
            int row = (int) e.getY() / ROW_COL_CONSTRAINTS;
            System.out.println(col + ", " + row + ", firstClick: " + firstClick);
            board.clickAction(col, row);
            if (firstClick) {
                firstClick = false;
            } else {
                firstClick = true;
            }
        });

        board = new Board(grid, blackPawn, whitePawn);
        board.initBoard();
        board.showBoard();

        Scene scene = new Scene(grid, BOARD_SIZE, BOARD_SIZE);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}




