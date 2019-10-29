package com.github.shaunlu.tutorial.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Elephant {

    private String sex;
    private String livingPlace;

    public Elephant(){ }
    @JsonCreator
    public Elephant(@JsonProperty("SEEX") String sex,
                   @JsonProperty("LIVPLACE") String livingPlace) {
        this.sex = sex;
        this.livingPlace = livingPlace;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLivingPlace() {
        return livingPlace;
    }

    public void setLivingPlace(String livingPlace) {
        this.livingPlace = livingPlace;
    }
}
