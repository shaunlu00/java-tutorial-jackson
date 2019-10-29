package com.github.shaunlu.tutorial.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreProperties({"id", "socialIdentityNumber"})
public class Employee {

    private Long id;
    private String name;
    private int age;
    private String socialIdentityNumber;
    private Job job;

    public Employee(){}

    public Employee(Long id, String name, int age, String socialIdentityNumber, Job job) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.socialIdentityNumber = socialIdentityNumber;
        this.job = job;
    }

    @JsonIgnoreType
    public static class Job {
        private String jobDescription;

        public Job(String jobDescription) {
            this.jobDescription = jobDescription;
        }

        public String getJobDescription() {
            return jobDescription;
        }

        public void setJobDescription(String jobDescription) {
            this.jobDescription = jobDescription;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSocialIdentityNumber() {
        return socialIdentityNumber;
    }

    public void setSocialIdentityNumber(String socialIdentityNumber) {
        this.socialIdentityNumber = socialIdentityNumber;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
