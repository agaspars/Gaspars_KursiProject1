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
        //return jdbcTemplate.query("SELECT * FROM notes", rowMapper);
        return jdbcTemplate.query("SELECT n.id AS n_id, n.text AS n_text, n.category AS n_category, u.id AS u_id, u.first_name AS u_firstName, u.last_name AS u_lastName " +
                "FROM notes n " +
                "INNER JOIN users u ON n.user_id = u.id", rowMapper);
    }

    public List<Note> getNotes(long userId) {
        RowMapper<Note> rowMapper = (rs, rowNumber) -> mapNote(rs);
        //return jdbcTemplate.query("SELECT * FROM notes", rowMapper);
        return jdbcTemplate.query("SELECT n.id AS n_id, n.text AS n_text, n.category AS n_category, u.id AS u_id, u.first_name AS u_firstName, u.last_name AS u_lastName " +
                "FROM notes n " +
                "INNER JOIN users u ON n.user_id = u.id " +
                "WHERE n.user_id = ?", rowMapper, userId);
    }
    //2nd method:
    private Note mapNote(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("u_id"));
        user.setFirstName(rs.getString("u_firstName"));
        user.setLastName(rs.getString("u_lastName"));

        Note note = new Note();

        note.setId(rs.getLong("n_id"));
        note.setText(rs.getString("n_text"));
        note.setAuthor(user);
        note.setCategory(Categories.valueOf(rs.getString("n_category")));
        return note;
    }

    public void storeNote (Note note) {
        jdbcTemplate.update("INSERT INTO notes (text, category, user_id) VALUES (?, ?::categories, ?)",
                note.getText(), note.getCategory().name(), note.getAuthor().getId());
    }
}
