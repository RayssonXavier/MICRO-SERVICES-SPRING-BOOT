package com.loja_online.apiusuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loja_online.apiusuario.dto.UsuarioDto;
import com.loja_online.apiusuario.service.UsuarioService;

@RestController
public class ApiUsuarioController {
    
    @Autowired
    private UsuarioService service;

    @GetMapping("/usuarios/")
    public List<UsuarioDto> obeterUsuarios() {
        var usuariosDto  = this.service.obterTodos();
        return usuariosDto;
    }

    @GetMapping("/usuario/{id}")
    public UsuarioDto obsterPeloId(@PathVariable long id) {
        return this.service.obterPeloId(id);
    }

    @PostMapping("/usuario/")
    public UsuarioDto salvar(UsuarioDto usuario) {
        return this.service.salvar(usuario);
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
