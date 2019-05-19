package com.kodilla.project1;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



public class Checkers extends Application {

    public static final int BOARD_SIZE = 500;

    private Image imageback = new Image("file:resources/checkers_board.jpg");

    BackgroundSize backgroundSize = new BackgroundSize(100, 100, true,
            true, true, false);

    BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER, backgroundSize);

    Background background = new Background(backgroundImage);



    @Override
    public void start(Stage primaryStage) {

        GridPane layout = new GridPane();
        layout.setBackground(background);
        layout.setPrefSize(BOARD_SIZE, BOARD_SIZE);

        Scene scene = new Scene(layout);
        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}




