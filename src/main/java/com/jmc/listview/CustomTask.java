package com.jmc.listview;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class CustomTask extends ListCell<Task> {
    private final CheckBox checkBox = new CheckBox();
    private final Text text = new Text();
    private final HBox hBox = new HBox(10, checkBox, text);

    @Override
    public void updateItem(Task item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            text.setText(item.getTask());
            checkBox.setSelected(item.isCompleted());

            checkBox.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
                if (isNowSelected) {
                    text.setStyle("-fx-strikethrough: true");
                } else {
                    text.setStyle("-fx-strikethrough: false");
                }
                if (getItem() != null) {
                    getItem().setCompleted(isNowSelected);
                }
            });

            setText(null);
            setGraphic(hBox);
        }
    }
}