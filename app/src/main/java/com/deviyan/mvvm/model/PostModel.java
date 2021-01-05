package com.deviyan.mvvm.model;

/*
* Getter and Setter
* used to protect your data.
* getter method returns its value
* setter method sets or updates its value
* known as accessors and mutator*/

public class PostModel {

    private String title, userId, id;
//    private String image;

    public PostModel() {
    }

    public PostModel(String title, String userId, String id) {
        this.title = title;
        this.userId = userId;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
