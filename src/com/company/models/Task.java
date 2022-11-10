package com.company.models;

public class Task {


    private long id;
    private String name;
    private String state;

    public Task(long id, String name, String state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public Task() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "id = " + id + " названия = " + name + " статус = " + state + "\n";

    }


}
