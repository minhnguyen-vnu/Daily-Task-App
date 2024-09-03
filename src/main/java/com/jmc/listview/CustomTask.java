//package com.jmc.listview;
//
//import javafx.scene.control.CheckBox;
//import javafx.scene.control.ListCell;
//import javafx.scene.layout.HBox;
//import javafx.scene.text.Text;
//
//public class CustomTask extends ListCell<Task> {
//    @Override
//    public void updateItem(Task item, boolean empty){
//        super.updateItem(item, empty);
//        if(empty){
//            setText(null);
//            setGraphic(null);
//        }
//        else{
//            CheckBox checkBox = new CheckBox();
//            Text text = new Text(item.getTask());
//            HBox hBox = new HBox(10, checkBox, text);
//            checkBox.selectedProperty().addListener(o -> {
//                if(checkBox.isSelected()) text.setStyle("-fx-strikethrough: true");
//                else text.setStyle("-fx-strikethrough: false");
//            });
//            setText(null);
//            setGraphic(hBox);
//        }
//    }
//}

package com.jmc.listview;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class CustomTask extends ListCell<Task> {
    private final CheckBox checkBox = new CheckBox();
    private final Text text = new Text();
    private final HBox hBox = new HBox(10, checkBox, text);

    public CustomTask() {
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
    }

    @Override
    public void updateItem(Task item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            text.setText(item.getTask());
            checkBox.setSelected(item.isCompleted());
            setText(null);
            setGraphic(hBox);
        }
    }
}