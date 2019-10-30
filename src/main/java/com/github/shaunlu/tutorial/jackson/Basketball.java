package com.github.shaunlu.tutorial.jackson;


public class Basketball extends Sports {

    private String pg;

    public Basketball(){
        super();
    }

    public Basketball(String pg) {
        super();
        this.pg = pg;
        this.setName("Basketball");
    }

    public String getPg() {
        return pg;
    }
    public void setPg(String pg) {
        this.pg = pg;
    }
}
