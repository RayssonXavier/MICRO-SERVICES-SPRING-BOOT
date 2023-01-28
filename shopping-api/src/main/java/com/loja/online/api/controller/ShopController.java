package com.loja.online.api.controller;

import com.loja.online.api.dto.ShopDto;
import com.loja.online.api.exceptions.UsuarioNotFoundException;
import com.loja.online.api.service.ShopService;
import com.loja.online.api.service.UsuarioService;
import com.shopping.client.DTO.UsuarioDto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {
    @Autowired
    ShopService service;

    @Autowired
    UsuarioService usuarioService;

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
    public ShopDto salvar(@RequestHeader(name = "chave", required = true) String chave, @RequestBody ShopDto shopDto) throws UsuarioNotFoundException {
        return this.service.salvar(shopDto, chave);
    }

    @GetMapping("/shopping/search")
    public List<ShopDto> filtrar(
        @RequestParam(name= "dataInicio", required = true) 
        @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataInicio,
        @RequestParam(name= "dataFim", required = false) 
        @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataFim,
        @RequestParam(name= "valorMinimo", required = false) 
        Float valorMinimo
    ) { 
        return this.service.obterShopDoFiltro(dataInicio, dataFim, valorMinimo);
    }

}
