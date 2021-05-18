package com.app.services;

import com.app.model.User;
import org.springframework.stereotype.Service;

@Service
public class NoteService {


    public String validateNote(User user) {
        String answer = "";
        if (user.getFirstName().isEmpty()) {
            answer += "First Name is empty; ";
        }
        if (user.getLastName().isEmpty()) {
            answer += "Last Name is empty; ";
        }
        if (user.getEmail().isEmpty()) {
            answer += "Email is empty; ";
        }
        return answer;
    }
}
