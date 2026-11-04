package com.manuelluvuvamo.arquiteturaspring.todos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("todos")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity novoTodo){
        return service.salvar(novoTodo);
    }

    @GetMapping
    public TodoEntity buscar(@RequestParam Integer id){
        return service.buscar(id);
    }

    @PutMapping
    public TodoEntity atualizar(@RequestParam Integer id, @RequestBody TodoEntity todo){
        return service.atualizar(id, todo);
    }
}
