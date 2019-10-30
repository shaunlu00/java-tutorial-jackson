package com.github.shaunlu.tutorial.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape= JsonFormat.Shape.OBJECT)
public enum  Status {

    TODO("todo", 1),
    IN_PROGRESS("in progress", 2),
    COMPLETED("completed", 3);
    private String key;
    private int value;
    Status(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
