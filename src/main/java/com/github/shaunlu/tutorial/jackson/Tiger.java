package com.github.shaunlu.tutorial.jackson;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class Tiger {

    private String name = "tiger";

    private Map<String, Object> properties = new HashMap();

    @JsonAnySetter
    public void add(String key, Object value) {
        properties.put(key, value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }
}
