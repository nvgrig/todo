package com.github.nvgrig.todo.repository;

import com.github.nvgrig.todo.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("DELETE FROM User u WHERE u.id=:id")
    int delete(@Param("id") int id);

    @EntityGraph(attributePaths = {"todoList"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT u FROM User u WHERE u.id=:id")
    User getWithTodos(@Param("id") int id);
}
