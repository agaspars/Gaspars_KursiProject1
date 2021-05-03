package com.app.controllers;

import com.app.model.oldNote;
import com.app.model.User;
import com.app.model.enums.Categories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class allNotes {

    @GetMapping("/allNotes")
    public String getAllNotes(Model model) {

        oldNote myNote = new oldNote(Categories.Work);

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
