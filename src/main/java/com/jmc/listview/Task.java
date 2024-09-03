package com.jmc.listview;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Task {
    private final StringProperty task;

    public Task(String task) {
        this.task = new SimpleStringProperty(task);
    }

    public String getTask(){
        return this.task.getValue();
    }

    public StringProperty getTaskProperty() {
        return this.task;
    }

    @Override
    public String toString(){
        return this.task.get();
    }
}
