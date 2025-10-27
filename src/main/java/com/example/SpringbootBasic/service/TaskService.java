package com.example.SpringbootBasic.service;

import com.example.SpringbootBasic.entities.Task;
import com.example.SpringbootBasic.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task create(Task task) {
        task.setEntregada(false);
        return repository.Save(task);
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task no encontrada"));
    }

    public Task update(Long id, Task input) {
        Task existing = findById(id);
        existing.setTitulo(input.getTitulo());
        existing.setDescripcion(input.getDescripcion());
        existing.setFechaEntrega(input.getFechaEntrega());
        existing.setStudentId(input.getStudentId());
        return repository.Save(existing);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    public Task marcarEntregada(Long id) {
        Task t = findById(id);
        t.setEntregada(true);
        return repository.Save(t);
    }
}


