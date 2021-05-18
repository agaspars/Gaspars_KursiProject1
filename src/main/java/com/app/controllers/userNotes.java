package com.app.controllers;

import com.app.model.oldNote;
import com.app.model.oldUser;
import com.app.model.enums.Categories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;


@Controller
public class userNotes {

    @GetMapping("/userNotes/{email}")
    public String getUserNotes(@PathVariable(value = "email") String email, Model model) {
        oldNote myNote = new oldNote(Categories.Work);

        myNote.addNote(new oldUser("Andrew", "G.", "a.g@gmail.com", "This is Andrew's first note"));
        myNote.addNote(new oldUser("Andrew", "G.", "a.g@gmail.com", "This is Andrew's second note"));
        myNote.addNote(new oldUser("Andrew", "G.", "a.g@gmail.com", "This is Andrew's third note"));
        myNote.addNote(new oldUser("Dima", "B.", "D.i@gmail.com", "This Dima's first note"));
        myNote.addNote(new oldUser("Dima", "B.", "D.i@gmail.com", "This Dima's second note"));
        myNote.addNote(new oldUser("Masha", "Cr.", "M.asha@gmail.com", "This is Alexa's first note"));
        myNote.addNote(new oldUser("Masha", "Cr.", "M.asha@gmail.com", "This is Alexa's second note"));
        List<oldUser> userNotes = new ArrayList<>();
        for( oldUser a : myNote.getAllNotes()) {
            if(a.getEmail().equals(email)) {
                userNotes.add(a);
            }
        }
        model.addAttribute("userNotes", userNotes);
        return "andrewNotes";
    }

}
