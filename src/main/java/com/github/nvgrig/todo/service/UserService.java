package com.github.nvgrig.todo.service;

import com.github.nvgrig.todo.model.User;
import com.github.nvgrig.todo.repository.UserRepository;

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        return null;
    }

    public void delete(int id) {
    }

    public User get(int id) {
        return null;
    }

    public User getWithTodos(int id) {
        return null;
    }

}
