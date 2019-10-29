package com.github.shaunlu.tutorial.jackson;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;

import java.util.HashMap;
import java.util.Map;

@JsonPropertyOrder({"manager", "name", "location"})
public class Company {

    private String name;
    private String location;
    private String manager;
    private Map<String, String> companyProperties = new HashMap<>();
    @JsonRawValue
    private String companyEmployee;

    public Company(){}

    public Company(String name, String location, String manager) {
        this.name = name;
        this.location = location;
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @JsonAnyGetter
    public Map<String, String> getCompanyProperties() {
        return companyProperties;
    }

    public void setCompanyProperties(Map<String, String> companyProperties) {
        this.companyProperties = companyProperties;
    }

    public String getCompanyEmployee() {
        return companyEmployee;
    }

    public void setCompanyEmployee(String companyEmployee) {
        this.companyEmployee = companyEmployee;
    }
}
