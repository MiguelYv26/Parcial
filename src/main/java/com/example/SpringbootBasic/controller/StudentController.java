package com.example.SpringbootBasic.controller;

import com.example.SpringbootBasic.entities.Student;
import com.example.SpringbootBasic.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/crear")
    public Student crear(@RequestParam String nombre, @RequestParam String email) {
        Student s = new Student(null, nombre, email);
        return service.create(s);
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return service.findById(id);
    }
}

