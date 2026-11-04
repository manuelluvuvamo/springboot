package com.manuelluvuvamo.arquiteturaspring.todos;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    public TodoRepository repository;

    public TodoService(TodoRepository todoRepository) {
        this.repository = todoRepository;
    }

    public TodoEntity salvar(TodoEntity novoTodo) {
        return repository.save(novoTodo);
    }


    public Optional<TodoEntity> buscar(Integer id) {
        return repository.findById(id);
    }

    public TodoEntity atualizar(Integer id, TodoEntity todo) {
        return repository.save(todo);
    }
}
