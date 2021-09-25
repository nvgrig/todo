package com.github.nvgrig.todo.controller;

import com.github.nvgrig.todo.model.User;
import com.github.nvgrig.todo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = UserRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController {
    static final String REST_URL = "/rest/profile";

    private final UserService service;

    public UserRestController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public User get(int id) {
        return service.get(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> register(@RequestBody User user) {
        User created = service.create(user);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL).build().toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping("/with-todos")
    public User getWithTodos(User user) {
        return service.getWithTodos(user.getId());
    }
}
