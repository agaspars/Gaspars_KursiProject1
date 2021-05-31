package com.app.dao;

import com.app.model.Note;
import com.app.model.User;
import com.app.model.enums.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NoteDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //1st method:
    public List<Note> getNotes() {
        RowMapper<Note> rowMapper = (rs, rowNumber) -> mapNote(rs);
        return jdbcTemplate.query("SELECT * FROM notes", rowMapper);
    }
    //2nd method:
    private Note mapNote(ResultSet rs) throws SQLException {
        Note note = new Note();

        note.setId(rs.getLong("id"));
        note.setText(rs.getString("text"));
        note.setCategory(Categories.valueOf(rs.getString("category")));
        return note;
    }

    public void storeNote (Note note) {
        jdbcTemplate.update("INSERT INTO notes (text, category, user_id) VALUES (?, ?::category, 1)",
                note.getText(), note.getCategory().toString());
    }
}
