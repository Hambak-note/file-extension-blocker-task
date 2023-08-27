package com.example.task.domain;

public enum Constant {

    MAX_EXTENSION_COUNT("200");

    private final String value;

    Constant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
