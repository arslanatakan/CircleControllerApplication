package com.example.circlecontrollerapplication;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleController extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();

        Circle circle = new Circle(100,100,50);
        circle.setFill(Color.RED);
        circle.setFocusTraversable(true);

        Button enlargeBtn = new Button("Enlarge");
        enlargeBtn.setLayoutX(50);
        enlargeBtn.setLayoutY(450);
        enlargeBtn.setFocusTraversable(false);//While moving the circle via the keyboard, it restricts access to the buttons.
        enlargeBtn.setOnMouseClicked(event -> {
            circle.setRadius(circle.getRadius()*1.2);
        });


        Button shrinkBtn = new Button("Shrink");
        shrinkBtn.setLayoutX(120);
        shrinkBtn.setLayoutY(450);
        shrinkBtn.setFocusTraversable(false); //While moving the circle via the keyboard, it restricts access to the buttons.
        shrinkBtn.setOnMouseClicked(event -> {
            circle.setRadius(circle.getRadius()*0.9);
        });


        circle.setOnMouseDragged(event -> {
            circle.setCenterX(event.getX());
            circle.setCenterY(event.getY());
        });

        circle.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()){
                case UP: circle.setCenterY(circle.getCenterY()-10); break;
                case DOWN: circle.setCenterY(circle.getCenterY()+10); break;
                case LEFT: circle.setCenterX(circle.getCenterX()-10); break;
                case RIGHT: circle.setCenterX(circle.getCenterX()+10); break;
            }
        });


        root.getChildren().addAll(circle,enlargeBtn,shrinkBtn);
        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Circle Controller");
        stage.show();

    }
}
