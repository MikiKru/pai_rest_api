package com.example.pai_rest_api.model;

public enum Status {
    NEW("new task"),
    IN_PROGRES("solving task"),
    DONE("closed task");

    private final String name;

    Status(String name) {
        this.name = name;
    }
}
