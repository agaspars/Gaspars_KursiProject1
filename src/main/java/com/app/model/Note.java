package com.app.model;

import com.app.model.enums.Categories;

public class Note {
    private String text;
    private Categories category;
    private User author;

    public Note(String text, Categories category, User author) {
        this.text = text;
        this.category = category;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
