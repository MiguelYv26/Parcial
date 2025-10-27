package com.example.SpringbootBasic.controller;

import com.example.SpringbootBasic.entities.Task;
import com.example.SpringbootBasic.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping("/crear")
    public Task crear(@RequestParam String titulo,
                      @RequestParam String descripcion,
                      @RequestParam String fechaEntrega, // formato yyyy-MM-dd
                      @RequestParam(required = false) Long studentId) {

        Task t = new Task(null, titulo, descripcion, LocalDate.parse(fechaEntrega), false, studentId);
        return service.create(t);
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id) {
        return service.findById(id);
    }
}


