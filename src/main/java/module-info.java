module com.jmc.listview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jmc.listview to javafx.fxml;
    exports com.jmc.listview;
}