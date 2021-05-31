package com.app.controllers;

import com.app.model.User;
import com.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registrationUser")
    public String getRegistrationPage(Model model) { // Model - для передачи данных
        model.addAttribute("userCreate", new User());
        return "registrationUser";
    }

    @PostMapping("/registrationUser")    //Попадаем сюда после нажатия кнопки Register!
    public String registerUser(@ModelAttribute User user, Model model) {
        String validatedUser = userService.validateUser(user);
        if (validatedUser.isEmpty()) {
            model.addAttribute("Name", user.getFirstName());
            return "successRegistration";
        } else {
            model.addAttribute("userCreate", user);
            model.addAttribute("errorString", validatedUser);
            return "errorRegistration";
        }
    }
}
