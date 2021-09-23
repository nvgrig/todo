package com.github.nvgrig.todo.repository;

import com.github.nvgrig.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
