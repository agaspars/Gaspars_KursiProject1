package com.app.model.enums;

public enum Categories {
    Work("This note has 'Work' category"),
    Journey("This note has 'Journey' category"),
    Business("This not has 'Business''' category"),
    Study("This note has 'Study' category");

    private String category;

    Categories(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return category;
    }
}
