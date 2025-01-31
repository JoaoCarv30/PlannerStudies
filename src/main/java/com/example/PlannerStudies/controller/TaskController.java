package com.example.PlannerStudies.controller;


import com.example.PlannerStudies.entity.Task;
import com.example.PlannerStudies.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return taskService.createTask(task); // Retorna ResponseEntity, como esperado
    }

    @GetMapping
    public List<Task> getTasks() {
        return  taskService.getAllTasks();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content após deletar
    }



}
