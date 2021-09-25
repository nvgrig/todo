package com.github.nvgrig.todo.controller;

import com.github.nvgrig.todo.model.Todo;
import com.github.nvgrig.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = TodoRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class TodoRestController {
    static final String REST_URL = "/rest/profile/todos";

    private final TodoService service;

    public TodoRestController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Todo get(@PathVariable int id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void complete(@PathVariable int id, @RequestParam boolean isCompleted) {
        service.complete(id, isCompleted);
    }

    @GetMapping("/not-completed")
    public List<Todo> getAllNotCompleted(@PathVariable int id) {
        return service.getAllNotCompleted(id);
    }
}
