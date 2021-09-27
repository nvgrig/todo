package com.github.nvgrig.todo.service;

import com.github.nvgrig.todo.model.User;
import com.github.nvgrig.todo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(user);
    }

    public User getWithTodos(int id) {
        return repository.getWithTodos(id);
    }
}
