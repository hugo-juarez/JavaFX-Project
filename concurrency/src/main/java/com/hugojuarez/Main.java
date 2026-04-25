package com.hugojuarez;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * JavaFX App
 */
public class Main extends Application {

    Button startBtn = new Button("Start");
    Button resetBtn = new Button("Reset");
    Button cancelBtn = new Button("Cancel");
    Button exitBtn = new Button("Exit");
    boolean started = false;

    ScheduledService<ObservableList<Integer>> service = new ScheduledService<>() {

        @Override
        protected Task<ObservableList<Integer>> createTask() {
            return new EvenNumberTask(1, 20, 100);
        }
    };

    @Override
    public void start(Stage stage) {

        service.setPeriod(Duration.seconds(5)); // Run task every 5 seconds. The maximum amount of time that it runs is equal to MAX integer value
        service.setRestartOnFailure(true); // When task fails it can restart
        service.setMaximumFailureCount(3); // Times it can fail

        startBtn.setOnAction(e -> {
            if (!started) {
                service.start();
                started = true;
                startBtn.setText("Restart");
            } else {
                service.restart();
            }
        });

        resetBtn.setOnAction( e -> service.reset());

        cancelBtn.setOnAction(e -> service.cancel());

        exitBtn.setOnAction(e -> stage.close());

        GridPane pane = new WorkerUI(service);
        HBox box = new HBox(5, startBtn, resetBtn, cancelBtn, exitBtn);
        BorderPane root = new BorderPane();
        root.setCenter(pane);
        root.setBottom(box);

        Scene scene = new Scene(root, 500, 450);
        stage.setScene(scene);
        stage.setTitle("Concurrency");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}