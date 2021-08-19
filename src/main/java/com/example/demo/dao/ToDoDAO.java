package com.example.demo.dao;

import com.example.demo.controllers.ToDoController;
import com.example.demo.mappers.ToDoRowMapper;
import com.example.demo.models.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@ComponentScan(basePackageClasses = ToDoController.class)
@Repository
public class ToDoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addToDo(ToDo todo) {
        jdbcTemplate.update(
                "insert into todo.todo (id, title, description, due, priority_id) values ( nextval('todo.id_seq') ,? , ?, ?, ?)",
                todo.getTitle(),
                todo.getDescription(),
                todo.getDueDate(),
                todo.getPriority()
        );
    }

    public List<ToDo> getallToDos() {
        return jdbcTemplate.query(
                "select * from todo.todo natural join todo.priority", new ToDoRowMapper());
    }

    public List<ToDo> getToDosByPriority(String priority) {
        return jdbcTemplate.query(
                "select * from todo.todo natural join todo.priority where todo.priority.priority = ?",
                new ToDoRowMapper(), priority);

    }

    public void updateToDo(ToDo todo) {
            jdbcTemplate.update(
                    "update todo.todo set description = ? , title = ?, due = ? where id = ?;",
                    todo.getDescription(),
                    todo.getTitle(),
                    todo.getId(),
                    todo.getDueDate(),
                    todo.getPriority(),
                    todo.getId()
                    );
        }

    public void deleteToDobyId(ToDo todo) {
        jdbcTemplate.update(
                "delete from todo.todo where id = ?" ,
                todo.getId()
        );
    }


}
