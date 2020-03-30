package com.testshiro.testshiro.model;

import org.springframework.stereotype.Component;

@Component
public class Test {
    private String id;

    private String name;

    public Test(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Test() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}