package com.example.projectoapi.controller;

import com.example.projectoapi.model.Produto;
import com.example.projectoapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController (ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam(value = "nome", required = false) String nome) {
        if (nome == null) {
            return  produtoRepository.findAll();
        }
        return produtoRepository.findByNome(nome);
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        var id = UUID.randomUUID().toString();
        produto.setId(id);
       produtoRepository.save(produto);
       return produto;
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable("id") String id, @RequestBody Produto produto) {
        produto.setId(id);
        produtoRepository.save(produto);
    }
    
    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id") String id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") String id) {
        produtoRepository.deleteById(id);
    }
}
