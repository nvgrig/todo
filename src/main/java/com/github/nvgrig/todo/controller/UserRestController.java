package com.github.nvgrig.todo.controller;

import com.github.nvgrig.todo.model.User;
import com.github.nvgrig.todo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = UserRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "User Controller")
public class UserRestController {
    static final String REST_URL = "/api/profile";

    private final UserService service;

    public UserRestController(UserService service) {
        this.service = service;
    }

    @GetMapping()
    public User get(@AuthenticationPrincipal AuthUser authUser) {
        return authUser.getUser();
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
    public User getWithTodos(@AuthenticationPrincipal AuthUser authUser) {
        return service.getWithTodos(authUser.id());
    }
}
