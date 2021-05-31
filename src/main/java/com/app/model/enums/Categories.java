package com.app.model.enums;

public enum Categories {
    WORK("Work"),
    STUDY("Study"),
    DAILY("Daily"),
    BUSINESS("Business");

    private String category;

    Categories(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return category;
    }
}
