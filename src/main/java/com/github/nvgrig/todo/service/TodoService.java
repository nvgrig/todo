package com.github.nvgrig.todo.service;

import com.github.nvgrig.todo.model.Todo;
import com.github.nvgrig.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class TodoService {
    private TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public Todo create(Todo todo) {
        Assert.notNull(todo, "todo must not be null");
        return repository.save(todo);
    }

    public Todo createLinkedTodo(Todo todo) {
        return null;
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Todo get(int id) {
        return repository.findById(id).orElse(null);
    }

    public void complete(int id, boolean isCompleted) {
        Todo todo = repository.getById(id);
        todo.setCompleted(isCompleted);
        repository.save(todo);
    }

    public List<Todo> getAllNotCompleted(int userId) {
        return repository.getAllNotCompleted(userId, false);
    }
}
