package com.example.SpringbootBasic.service;

import com.example.SpringbootBasic.entities.Student;
import com.example.SpringbootBasic.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student create(Student student) {
        return repository.Save(student);
    }

    public List<Student> findAll() {
        return repository.findAll();
    }

    public Student findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student no encontrado"));
    }

    public Student update(Long id, Student input) {
        Student existing = findById(id);
        existing.setNombre(input.getNombre());
        existing.setEmail(input.getEmail());
        return repository.Save(existing);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}

