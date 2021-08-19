package com.example.demo.controllers;

import com.example.demo.dao.ToDoDAO;
import com.example.demo.models.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoController {
    @Autowired
    ToDoDAO todoDAO;

    @GetMapping("/greeting")
    public String greeting() {
        String z = "Hello World";
        return z;
    }

    @GetMapping("/get")
    public List<ToDo> getallToDos() {
        return todoDAO.getallToDos();
    }

    @GetMapping(value = "/get/{priority}", produces = "application/json")
    public List<ToDo> getToDosByPriority(@PathVariable String priority) {

        return todoDAO.getToDosByPriority(priority);
    }

    @PostMapping(value = "/create", consumes = "application/json")
    public void addToDo(@RequestBody ToDo request) {
        todoDAO.addToDo(request);
    }

    @PutMapping(value = "/update", consumes = "application/json")
    public void updateToDo(@RequestBody ToDo request) {
        todoDAO.updateToDo(request);
    }

    @DeleteMapping(value = "/deletebyid", consumes = "application/json")
    public void deleteToDobyId(@RequestBody ToDo request) {
        todoDAO.deleteToDobyId(request);
    }
}
