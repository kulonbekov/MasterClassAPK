package com.company.models;

public class User {
    private long id;
    private String login;
    private String email;
    private String password;
    private String password_2;


    public User(long id, String login, String email, String password, String password_2) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.password_2 = password_2;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_2() {
        return password_2;
    }

    public void setPassword_2(String password_2) {
        this.password_2 = password_2;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", password_2='" + password_2 + '\'' +
                '}';
    }
}
