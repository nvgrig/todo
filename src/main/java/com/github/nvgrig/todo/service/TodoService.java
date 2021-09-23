package com.github.nvgrig.todo.service;

import com.github.nvgrig.todo.model.Todo;
import com.github.nvgrig.todo.repository.TodoRepository;

import java.util.List;

public class TodoService {
    private TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public Todo create(Todo todo) {
        return null;
    }

    public Todo createLinkedTodo(Todo todo) {
        return null;
    }

    public void delete(int id) {
    }

    public Todo get(int id) {
        return null;
    }

    public void complete(int id) {
    }

    public List<Todo> getAllNotCompleted() {
        return null;
    }
}
