package com.model;

public class MessageModel {

    public String getMessage(String name) {
        if (name == null || name.trim().isEmpty()) {
            name = "Guest";
        }
        return "Hello " + name + ", Welcome to MVC Example!";
    }
}