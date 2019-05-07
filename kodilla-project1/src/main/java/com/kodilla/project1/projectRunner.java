package com.kodilla.project1;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class projectRunner extends Application {

    Stage window;
    Scene scene1, scene2;
    Button button, button2, button3Scene1, button4Scene2;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*primaryStage.setTitle("Chess");
        button = new Button("Click me");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button1");
            }
        });
        button2 = new Button("Click me2");
        button2.setOnAction(e -> System.out.println("Button2"));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        layout.getChildren().add(button2);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();*/
        window = primaryStage;

        Label label1 = new Label("Welcome to the first scene");
        Button button3Scene1 = new Button();
        button3Scene1.setText("Go to scene2");
        button3Scene1.setOnAction(e -> window.setScene(scene2));

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button3Scene1);
        scene1 = new Scene(layout1, 200,200);

        Button button4Scene2 = new Button();
        button4Scene2.setText("Go to scene1");;
        button4Scene2.setOnAction(e -> window.setScene(scene1));

        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button4Scene2);
        scene2 = new Scene(layout2, 600, 300);

        window.setScene(scene1);
        window.setTitle("Title1");
        window.show();

        TreeView tree = new TreeView<>();
        tree.getSelectionModel().selectedItemProperty().addListener( (v, newValue, oldValue) -> {
            if (newValue != null) {
                System.out.println(newValue);
            }
        });

    }
}
