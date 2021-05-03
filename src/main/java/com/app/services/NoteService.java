package com.app.services;

import com.app.model.Note;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

//    public Note validateNote(Note note) {
//        if (note.getFirstName().isEmpty() || note.getLastName().isEmpty() ||
//                note.getEmail().isEmpty() || note.getNote().isEmpty()) {
//            return null;
//        }
//        return note;
//    }

    public String validateNote(Note note) {
        String answer = "";
        if (note.getFirstName().isEmpty()) {
            answer += "First Name is empty, ";
        }
        if (note.getLastName().isEmpty()) {
            answer += "Last Name is empty, ";
        }
        if (note.getEmail().isEmpty()) {
            answer += "Email is empty, ";
        }
        if (note.getNote().isEmpty()) {
            answer += "Note is empty, ";
        }
        if (note.getNote().length() >= 1000) {
            answer += "Note is too long";
        }
        return answer;
    }
}
