package com.github.shaunlu.tutorial.jackson;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Computer {

    @JsonAlias({"Core", "CCORE", "CO_RE"})
    private String core;

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }
}
