package com.loja.online.shopping.api.controller;

import com.loja.online.shopping.api.dto.ShopDto;
import com.loja.online.shopping.api.service.ShopService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {
    @Autowired
    ShopService service;

    @GetMapping("/shopping")
    public List<ShopDto> obterTodos() {
        return this.service.obterTodos();
    }

    @GetMapping("/shopping/usuario-identificador/{usuarioIdentidficador}")
    public List<ShopDto> obterPeloUsuarioIdentificador(@PathVariable ("usuarioIdentidficador") String usuarioIdentificado) {
        return this.service.obterPeloUsuarioIdentificador(usuarioIdentificado);
    }

    @GetMapping("/shopping/{id}")
    public ShopDto obterPeloId(@PathVariable("id") long id) {
        return this.service.obterPeloId(id);
    }

    @PostMapping("/shopping")
    public ShopDto salvar(@RequestBody ShopDto shopDto) {
        return this.service.salvar(shopDto);
    }
}
