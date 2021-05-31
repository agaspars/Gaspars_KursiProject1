package com.app.controllers;

import com.app.model.Note;
import com.app.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping("/noteCreate")
    public String noteCreatePage(Model model) {
        model.addAttribute("createdNote", new Note());
        return "noteCreate";
    }

    @PostMapping("/noteCreate")    //Попадаем сюда после нажатия кнопки Register!
    public String noteCreate(@ModelAttribute Note note, Model model) {
        String validatedNote = noteService.validateNote(note);
        if (validatedNote.isEmpty()==true) {
            return "successNoteCreate";
        } else {
            model.addAttribute("errorMessage", validatedNote);
            return "errorNoteCreate";
        }
    }
}
