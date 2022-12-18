package com.lojaonlineapiprodutos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lojaonlineapiprodutos.dto.ProdutoDto;
import com.lojaonlineapiprodutos.exception.ProdutoNotFoundException;
import com.lojaonlineapiprodutos.service.ProdutoService;

@RestController
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/produto")
    public List<ProdutoDto> obterTodos() {
        return this.produtoService.obterTodos();
    }

    @GetMapping("/produto/categoria/{categoriaId}")
    public List<ProdutoDto> obterPorCategoria(@PathVariable("categoriaId") long categoriaId) {
        return this.produtoService.obterProdutoPorCategoria(categoriaId);
    }

    @GetMapping("/produto/identificador/{identificador}")
    public ProdutoDto obterPorIdentificador(@PathVariable("identificador") String identificador) {
        return this.produtoService.obterProdutoPorIdentificador(identificador);
    }

    @PostMapping("/produto")
    public ProdutoDto salvar(@Valid @RequestBody ProdutoDto produtoDto) throws ProdutoNotFoundException {
        return this.produtoService.salvar(produtoDto);
    }

    @DeleteMapping("/produto/{id}")
    public void deletar(@PathVariable("id") long id) throws ProdutoNotFoundException {
        this.produtoService.deletar(id);
    }
}
