package Model;

import Model.enums.Categories;
import Model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Note {
    private String title;
    private String text;
    private Categories category;
    private List<User> allNotes = new ArrayList<>();

    //Конструктор для 1-3 задания
    public Note(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Note(Categories category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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


    public List<User> getAllNotes() {
        return allNotes;
    }

    public void setAllNotes(List<User> allNotes) {
        this.allNotes = allNotes;
    }

    public void printNote() {
        System.out.println("------" + title + "------");
        System.out.println("Note: " + text + "\n");
    }

    public void addNote(User a) {
        allNotes.add(a);
    }

    public void printAllNotes() {
        for(User a : allNotes) {
            System.out.println(a.getNote());
        }
    }

    public void printUserNotes(String userName) {
        for(User a: allNotes) {
            System.out.println(a.getFirstName().equals(userName) ? a.getNote() : "The person is not right");
        }
    }
}
