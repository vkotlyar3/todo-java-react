package com.todo.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TasksController {
    @Autowired
    TasksRepository tasksRepository;

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
        return tasksRepository.save(task);
    }

    @PutMapping("/tasks")
    public Optional<Task> updateTask(@RequestBody Task task) {
        Optional<Task> optionalTask = tasksRepository.findById(task.getId());

        optionalTask.ifPresent(foundTask -> {
            foundTask.setEstimate(task.getEstimate());
            foundTask.setTitle(task.getTitle());
            tasksRepository.save(foundTask);
        });

        return tasksRepository.findById(task.getId());
    }

    @DeleteMapping("/tasks/{taskId}")
    public String deleteTask(@PathVariable Integer taskId) {
        tasksRepository.deleteById(taskId);
        return "success";
    }
}
