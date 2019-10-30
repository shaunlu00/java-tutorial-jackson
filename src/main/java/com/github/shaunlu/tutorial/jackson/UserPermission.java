package com.github.shaunlu.tutorial.jackson;

public class UserPermission {
    private String id;
    public UserPermission(){}

    public UserPermission(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
