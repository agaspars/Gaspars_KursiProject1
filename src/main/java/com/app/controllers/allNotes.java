package com.app.controllers;

import model.Note;
import model.User;
import model.enums.Categories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class allNotes {

    @GetMapping("/allNotes")
    public String getAllNotes(Model model) {

        Note myNote = new Note(Categories.Work);

        myNote.addNote(new User("Andrew", "G.", "a.g@gmail.com", "This is Andrew's first note"));
        myNote.addNote(new User("Andrew", "G.", "a.g@gmail.com", "This is Andrew's second note"));
        myNote.addNote(new User("Andrew", "G.", "a.g@gmail.com", "This is Andrew's third note"));
        myNote.addNote(new User("Dima", "B.", "D.i@gmail.com", "This Dima's first note"));
        myNote.addNote(new User("Dima", "B.", "D.i@gmail.com", "This Dima's second note"));
        myNote.addNote(new User("Masha", "Cr.", "M.asha@gmail.com", "This is Alexa's first note"));
        myNote.addNote(new User("Masha", "Cr.", "M.asha@gmail.com", "This is Alexa's second note"));

        model.addAttribute("notes", myNote.getAllNotes());
        return "andrewNotes";
    }
}
