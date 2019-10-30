package com.github.shaunlu.tutorial.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum  State {

    ACTIVE("active", 0),
    DEAD("dead", 1),
    SUSPEND("suspend", 2),
    UNKNOW("unknow", 3);

    private String key;
    private int value;

    State(String key, int value) {
        this.key = key;
        this.value = value;
    }

    @JsonCreator
    public static State createState(int value) {
        for(State state : values()){
            if (state.getValue() == value) {
                return state;
            }
        }
        return State.UNKNOW;
    }

    @JsonValue
    public String getStateValue(){
        return key;
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
