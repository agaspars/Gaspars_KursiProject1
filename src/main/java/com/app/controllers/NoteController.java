package com.app.controllers;

import com.app.model.Note;
import com.app.services.NoteService;
import com.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;

    @Autowired
    private UserService userService;

    @GetMapping("/noteCreate")
    public String noteCreatePage(Model model) {
        model.addAttribute("notes", noteService.getNotes());
        model.addAttribute("createdNote", new Note());
        model.addAttribute("users", userService.getUsers());
        return "noteDirectory/noteCreate";
    }

    @PostMapping("/noteCreate")    //Попадаем сюда после нажатия кнопки Register!
    public String noteCreate(@ModelAttribute Note note, Model model) {
        String validatedNote = noteService.validateNote(note);
//        if (validatedNote.isEmpty()==true) {
//            return "noteDirectory/successNoteCreate";
//        } else {
//            model.addAttribute("createdNote", note);
//            model.addAttribute("errorMessage", validatedNote);
//            return "noteDirectory/errorNoteCreate";
//        }
        model.addAttribute("error", validatedNote);
        model.addAttribute("createdNote", note);
        model.addAttribute("notes", noteService.getNotes());
        model.addAttribute("users", userService.getUsers());
        return "noteDirectory/noteCreate";
    }

    @GetMapping("/noteCreate/{id}")
    public String noteCreate(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("notes", noteService.getNotes(id));
        model.addAttribute("createdNote", new Note());
        model.addAttribute("users", userService.getUsers());

        return "noteDirectory/noteCreate";
    }
}
