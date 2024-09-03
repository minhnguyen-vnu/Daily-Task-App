//package com.jmc.listview;
//
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.property.StringProperty;
//
//public class Task {
//    private final StringProperty task;
//
//    public Task(String task) {
//        this.task = new SimpleStringProperty(task);
//    }
//
//    public String getTask(){
//        return this.task.getValue();
//    }
//
//    public StringProperty getTaskProperty() {
//        return this.task;
//    }
//
//    @Override
//    public String toString(){
//        return this.task.get();
//    }
//}

package com.jmc.listview;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Task {
    private final StringProperty task;
    private final BooleanProperty completed;

    public Task(String task) {
        this.task = new SimpleStringProperty(task);
        this.completed = new SimpleBooleanProperty(false);
    }

    public String getTask() {
        return this.task.getValue();
    }

    public StringProperty getTaskProperty() {
        return this.task;
    }

    public boolean isCompleted() {
        return this.completed.get();
    }

    public void setCompleted(boolean completed) {
        this.completed.set(completed);
    }

    public BooleanProperty completedProperty() {
        return this.completed;
    }

    @Override
    public String toString() {
        return this.task.get();
    }
}
