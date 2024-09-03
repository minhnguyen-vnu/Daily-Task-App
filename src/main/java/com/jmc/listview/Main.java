package com.jmc.listview;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        TextField textField = new TextField();
        textField.setPromptText("Add a task to do");
        textField.setMaxWidth(300);
        Button button = new Button("Add");

        ListView<Task> listView = new ListView<>();
        ObservableList<Task> daily_task = FXCollections.observableArrayList(
                new Task("Get up"),
                new Task("Have Breakfast"),
                new Task("Go to work"),
                new Task("Check my Email"),
                new Task("Complete Deadlines"),
                new Task("Have Lunch"),
                new Task("Take a nap"),
                new Task("Complete Deadlines again"),
                new Task("Go home"),
                new Task("Have dinner"),
                new Task("Get into the bed")
        );

        listView.setCellFactory(taskListView -> (new CustomTask()));
        listView.setItems(daily_task);

        button.setOnMouseClicked(e -> {
            if(!textField.textProperty().get().isEmpty()){
                String txt = textField.getText();
                daily_task.add(new Task(txt));
                textField.clear();
            }
        });

        vBox.getChildren().addAll(listView, textField, button);
        VBox.setVgrow(listView, Priority.ALWAYS);


        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.setTitle("Daily Task");
        stage.show();
    }

    public static void main(String args[]){
        launch();
    }
}