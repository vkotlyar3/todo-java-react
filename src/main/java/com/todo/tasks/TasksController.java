package com.todo.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TasksController {
    @Autowired
    TasksRepository tasksRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return tasksRepository.findAll();
    }

    @GetMapping("/tasks/{taskId}")
    public Optional<Task> getTask(@PathVariable Integer taskId) {
        return tasksRepository.findById(taskId);
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        Task savedTask = tasksRepository.save(task);
        return savedTask;
    }
}
