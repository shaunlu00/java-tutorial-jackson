package com.github.shaunlu.tutorial.jackson;


public class Swim extends Sports {

    private String swimType;

    public Swim(){super();}

    public Swim(String swimType) {
        super();
        this.swimType = swimType;
        this.setName("Swim");
    }

    public String getSwimType() {
        return swimType;
    }

    public void setSwimType(String swimType) {
        this.swimType = swimType;
    }
}
