package com.github.shaunlu.tutorial.jackson;

import com.fasterxml.jackson.annotation.JsonView;

public class User {
    @JsonView(UserJsonView.Internal.class)
    private String id;
    @JsonView(UserJsonView.Internal.class)
    private String birthday;
    @JsonView(UserJsonView.Public.class)
    private String name;
    @JsonView(UserJsonView.Public.class)
    private String email;

    public User(){}

    public User(String id, String birthday, String name, String email) {
        this.id = id;
        this.birthday = birthday;
        this.name = name;
        this.email = email;
    }
}
