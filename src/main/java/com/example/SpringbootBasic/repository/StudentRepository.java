package com.example.SpringbootBasic.repository;

import com.example.SpringbootBasic.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {
    private final List<Student> students = new ArrayList<>();
    private long nextId = 1;

    public Student Save(Student student) {
        if (student.getId() == null) {
            student.setId(nextId++);
            students.add(student);
        } else {
            students.removeIf(s -> s.getId().equals(student.getId()));
            students.add(student);
        }
        return student;
    }

    public List<Student> findAll() {
        return students;
    }

    public Optional<Student> findById(Long id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    public void deleteById(Long id) {
        students.removeIf(s -> s.getId().equals(id));
    }
}
