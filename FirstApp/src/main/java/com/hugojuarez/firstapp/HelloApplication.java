package com.hugojuarez.firstapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void init() throws Exception {
        System.out.println("Before the App starts");
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Closing the Application");
    }

    @Override
    public void start(Stage stage) {
        System.out.println(Thread.currentThread().getName());

        VBox root = new VBox();

        // Center elements
        root.setAlignment(Pos.CENTER);

        // Adding padding & spacing
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setSpacing(20);

        Label label = new Label();
        Button button = new Button("Click Me!");
        Button button1 = new Button("Exit explicitly");

        // Adding button action
        button.setOnAction(e -> label.setText("Welcome to JavaFX Application!"));
        button1.setOnAction(e -> Platform.exit());

        // Adding to a layout
        root.getChildren().addAll(label, button, button1);

        // Create a scene and add it to stage
        Scene scene = new Scene(root, 350, 300);
        stage.setScene(scene);

        // Show window
        stage.setTitle("JavaFX Application");
        stage.show();
    }
}