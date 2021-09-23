package com.github.nvgrig.todo.model;

import java.time.LocalDate;

public class Todo {
    protected Integer id;

    private String description;

    private Boolean isCompleted;

    private LocalDate creationDate;

    public Todo() {
    }

    public Todo(Integer id, String description, Boolean isCompleted, LocalDate creationDate) {
        this.id = id;
        this.description = description;
        this.isCompleted = isCompleted;
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isCompleted=" + isCompleted +
                ", creationDate=" + creationDate +
                '}';
    }
}
