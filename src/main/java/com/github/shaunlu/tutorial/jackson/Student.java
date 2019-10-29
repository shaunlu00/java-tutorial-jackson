package com.github.shaunlu.tutorial.jackson;

import com.fasterxml.jackson.annotation.JsonValue;

public class Student {
    private String name;

    private Major major = new Major("a001", "Mathematics");

    public Student(){}
    public Student(String name) {
        this.name = name;
    }


    public static class Major {
        private String id;
        private String name;

        public Major(){}

        public Major(String id, String name) {
            this.id = id;
            this.name = name;
        }

        @JsonValue
        public String getValue(){
            return id + ":" + name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }
}
