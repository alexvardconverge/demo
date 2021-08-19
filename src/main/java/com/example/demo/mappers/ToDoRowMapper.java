package com.example.demo.mappers;


import com.example.demo.models.ToDo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ToDoRowMapper implements RowMapper<ToDo> {

    @Override
    public ToDo mapRow(ResultSet rs, int rowNum) throws SQLException {

        ToDo todo = new ToDo();

        todo.setId(rs.getInt("id"));
        todo.setTitle(rs.getString("title"));
        todo.setDescription(rs.getString("description"));
        todo.setDueDate(rs.getDate("due"));
        todo.setPriority(rs.getInt("priority"));

        return todo;
    }
}
