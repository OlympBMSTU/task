package com.olymp.excercices.views;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Subject {
    @JsonProperty("math")
    MATH("math"),
    @JsonProperty("informatics")
    INFORMATICS("informatics"),
    @JsonProperty("physics")
    PHYSICS("physics");

    private String name;
    Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
