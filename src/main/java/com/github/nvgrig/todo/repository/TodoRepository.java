package com.github.nvgrig.todo.repository;

import com.github.nvgrig.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
