package com.company.models;

public class Task {


    private long id;
    private String name;
    private String state;

    private User userId;

    public Task(long id, String name, String state, User userId) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.userId = userId;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "id = " + id + " названия = " + name + " статус = " + state + ", пользователь = " + userId + "\n";

    }


}
