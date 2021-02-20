package com.app.dagger2.bean;

import com.app.dagger2.App;

import javax.inject.Inject;

public class Student {
    private int id;
    private String name;

    @Inject
    public Student(App app) {
        System.out.println("Student create!!!");
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
