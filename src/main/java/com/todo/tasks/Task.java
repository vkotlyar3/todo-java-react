package com.todo.tasks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task {
    @Id
    @GeneratedValue()
    private Integer id;

    private String title;

    private Integer estimate;

    protected Task() {
    }

    public void setEstimate(Integer estimate) {
        this.estimate = estimate;
    }

    public Integer getEstimate() {
        return estimate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
