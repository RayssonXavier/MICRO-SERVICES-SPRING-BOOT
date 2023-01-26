package com.loja.online.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loja.online.api.dto.UsuarioDto;
import com.loja.online.api.exception.UsuarioNotFoundException;
import com.loja.online.api.service.UsuarioService;


@RestController
public class ApiUsuarioController {
    
    @Autowired
    private UsuarioService service;

    @GetMapping("/usuario")
    public List<UsuarioDto> obeterUsuarios() {
        var usuariosDto  = this.service.obterTodos();
        return usuariosDto;
    }

    @GetMapping("/usuario/{id}")
    public UsuarioDto obsterPeloId(@PathVariable long id) {
        return this.service.obterPeloId(id);
    }

    @GetMapping("/usuario/cpf/{cpf}")
    public UsuarioDto obsterPeloCpf(@PathVariable String cpf) throws UsuarioNotFoundException{
        return this.service.obterPeloCpf(cpf);
    }

    @PostMapping("/usuario")
    public UsuarioDto salvar( @Valid @RequestBody UsuarioDto usuarioDto){
        return this.service.salvar(usuarioDto);
    }

    @DeleteMapping("/usuario/{id}")
    public UsuarioDto deletar(@PathVariable long id) {
        return this.service.deletar(id);
    }

    @GetMapping("/usuario/filtrar")
    public List<UsuarioDto> filtrarPeloNome(
             @RequestParam(name = "nome", required = true )
             String nome) {
        return this.service.filtroPelaParteNome(nome);
    }
}
