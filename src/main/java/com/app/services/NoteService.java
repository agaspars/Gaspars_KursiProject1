package com.app.services;

import com.app.dao.NoteDao;
import com.app.model.Note;
import com.app.model.enums.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    @Autowired
    private NoteDao noteDao;

    public String validateNote(Note note) {
        String answer = "";
        if (note.getText().isEmpty()) {
            answer += "Note is empty; ";
        }
        if (note.getCategory() != Categories.BUSINESS && note.getCategory() != Categories.WORK
                && note.getCategory() != Categories.DAILY && note.getCategory() != Categories.STUDY) {
            answer += "Category is empty; ";
        }
        if (answer.isEmpty() == true) {
            noteDao.storeNote(note);
        }
        return answer;
    }
}
