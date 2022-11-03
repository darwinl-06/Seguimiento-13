package com.example.seguimiento13.model;

public class User {
    private String password;
    private String content;

    public User(String password, String content) {
        this.password = password;
        this.content = content;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
