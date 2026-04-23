package com.hugojuarez;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Group group = new Group();
        Button one = new Button("One");
        Button two = new Button("Two");
        one.setLayoutX(50);
        one.setLayoutY(10);
        two.layoutXProperty().bind(one.layoutXProperty().add(one.widthProperty().add(10)));
        two.layoutYProperty().bind(one.layoutYProperty());
        group.setEffect(new DropShadow());
        group.setRotate(10);
        group.getChildren().addAll(one, two);
        Scene scene = new Scene(group, 350, 300);
        stage.setTitle("Group Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}