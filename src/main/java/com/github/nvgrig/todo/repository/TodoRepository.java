package com.github.nvgrig.todo.repository;

import com.github.nvgrig.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    @Query("DELETE FROM Todo t WHERE t.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT t FROM Todo t WHERE t.user.id=:userId AND t.isCompleted=:isCompleted")
    List<Todo> getAllNotCompleted(@Param("userId") int userId, @Param("isCompleted") boolean isCompleted);

}
