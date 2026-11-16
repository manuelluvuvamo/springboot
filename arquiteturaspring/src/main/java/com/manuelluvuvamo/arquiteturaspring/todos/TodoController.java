package com.manuelluvuvamo.arquiteturaspring.todos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("todos")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity novoTodo){
        try {
            return service.salvar(novoTodo);
        } catch (IllegalArgumentException e) {
            var mensagemErro = e.getMessage();
            throw  new ResponseStatusException(HttpStatus.CONFLICT, mensagemErro);
        }

    }

    @GetMapping("{id}")
    public TodoEntity buscar(@PathVariable("id") Integer id){
        return service.buscarPorId(id);
    }

    @PutMapping
    public TodoEntity atualizar(@RequestParam Integer id, @RequestBody TodoEntity todo){
        return service.atualizar(id, todo);
    }

    @PutMapping("{id}")
    public void atualizarStatus(@PathVariable("id") Integer id, @RequestBody TodoEntity todo) {
        todo.setId(id);
        service.atualizarStatus(todo);
    }
}
