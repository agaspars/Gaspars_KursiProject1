package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class myNotes {

    @GetMapping("/andrewNotes")
    public String getMyNotes() {
        return "andrewNotes";
    }
}
