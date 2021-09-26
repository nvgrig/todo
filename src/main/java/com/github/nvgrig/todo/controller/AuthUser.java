package com.github.nvgrig.todo.controller;

import com.github.nvgrig.todo.model.Role;
import com.github.nvgrig.todo.model.User;

import java.util.List;

public class AuthUser extends org.springframework.security.core.userdetails.User {

    private final User user;

    public AuthUser(User user) {
        super(user.getLogin(), user.getPassword(), List.of(Role.USER));
        this.user = user;
    }

    public int id() {
        return user.getId();
    }

    public User getUser() {
        return user;
    }
}