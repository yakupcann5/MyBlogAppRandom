package com.example.androidassigment.model;

public class Post {
    private int userId;
    private int id;
    private String title;
    private boolean complate;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public boolean getComplate() {
        return complate;
    }
    public void setComplate(boolean complate) {
        this.complate = complate;
    }
}
