package com.app.controllers;

import com.app.model.User;
import com.app.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private NoteService noteService;


    @GetMapping("/registrationNote")
    public String getRegistrationPage(Model model) { // Model - для передачи данных
        model.addAttribute("noteCreate", new User());
        return "registrationNote";
    }

    @PostMapping("/registrationNote")    //Попадаем сюда после нажатия кнопки Register!
    public String registerUser(@ModelAttribute User user, Model model) {
        String validatedNote = noteService.validateNote(user);
        if (validatedNote.isEmpty()) {
            model.addAttribute("Name", user.getFirstName());
            return "successRegistration";
        } else {
            model.addAttribute("noteCreate", user);
          //  model.addAttribute("thisNote", note);
            model.addAttribute("errorString", validatedNote);
            return "errorRegistration";
        }
    }
}
