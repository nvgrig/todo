package com.github.nvgrig.todo.controller;

import com.github.nvgrig.todo.model.Todo;
import com.github.nvgrig.todo.model.User;
import com.github.nvgrig.todo.service.TodoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = TodoRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Todo Controller")
public class TodoRestController {
    static final String REST_URL = "/api/profile/todos";

    private final TodoService service;

    public TodoRestController(TodoService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        Todo created = service.create(todo);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL).build().toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping("/{id}")
    public Todo get(@PathVariable int id) {
        return service.get(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void complete(@PathVariable int id) {
        service.complete(id, true);
    }

    @GetMapping("/not-completed")
    public List<Todo> getAllNotCompleted(@AuthenticationPrincipal AuthUser authUser) {
        return service.getAllNotCompleted(authUser.id());
    }
}
