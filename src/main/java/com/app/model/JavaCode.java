package com.app.model;

import com.app.model.enums.Categories;

import java.util.List;

public class JavaCode {

    public static void main(String[] Args) {
        //3 Задание:
        System.out.println("1-3 Задания:");
        oldUser andrejs = new oldUser("Andrejs", "Test", "a.t@gmail.com");
        andrejs.printFullInfo();

        oldNote andrejsNote = new oldNote("April's notes","These are my april's notes");
        andrejsNote.printNote();

        Category andrejsNoteCategory = new Category("Business");
        andrejsNoteCategory.printCategory();

        //4,5,6 задания:
        System.out.println("\n\n4-6 Задания:");

        oldNote myNote = new oldNote(Categories.WORK);

        System.out.println("The category is: " + myNote.getCategory());

        myNote.addNote(new oldUser("Andrew", "G.", "a.g@gmail.com", "This is Andrew's first note"));
        myNote.addNote(new oldUser("Andrew", "G.", "a.g@gmail.com", "This is Andrew's second note"));
        myNote.addNote(new oldUser("Andrew", "G.", "a.g@gmail.com", "This is Andrew's third note"));
        myNote.addNote(new oldUser("Dima", "B.", "D.i@gmail.com", "This Dima's first note"));
        myNote.addNote(new oldUser("Dima", "B.", "D.i@gmail.com", "This Dima's second note"));
        myNote.addNote(new oldUser("Masha", "Cr.", "M.asha@gmail.com", "This is Alexa's first note"));
        myNote.addNote(new oldUser("Masha", "Cr.", "M.asha@gmail.com", "This is Alexa's second note"));

        //Через методы в классе Note:
        System.out.println("\n~~~~~~~~~~~~~\n"+"Using methods\n~~~~~~~~~~~~~");

        myNote.printAllNotes();                      //All notes
        System.out.println();
        myNote.printUserNotes("Andrew");    //Andrew's notes

        List<oldUser> allUsers = myNote.getAllNotes();

        //Через циклы в main
        System.out.println("\n~~~~~~~~~~~~~\n"+"Using loops\n~~~~~~~~~~~~~");
        //Все заметки:
        System.out.println("All users: ");
        for(oldUser u : allUsers) {
            System.out.println(u.getNote());
        }
        //Заметки 1 человека - Андрея
        System.out.println();
        System.out.println("Andrew's notes:");

        for(oldUser a : allUsers) {
            System.out.println(a.getFirstName().equals("Andrew") ? a.getNote() : "The person is not Andrew");
        }
    }

}
