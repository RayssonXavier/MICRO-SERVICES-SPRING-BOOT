package com.loja.online.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.client.HttpClientErrorException;

import org.springframework.web.client.RestTemplate;


import com.google.gson.Gson;

import com.loja.online.api.dto.ErroDto;
import com.loja.online.api.exceptions.UsuarioNotFoundException;
import com.shopping.client.DTO.UsuarioDto;

@Service
public class UsuarioService {
    
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Gson gson;

    public UsuarioDto obterPorCpf(String cpf) {
        try {
            var url = "http://localhost:8080/usuario/cpf/"+cpf;
            var resposnse = this.restTemplate.getForEntity(url, UsuarioDto.class);
            return resposnse.getBody();
        } catch (HttpClientErrorException e) {
            ErroDto erro = this.gson.fromJson(e.getResponseBodyAsString(), ErroDto.class);
            throw new UsuarioNotFoundException(erro.getMessage());
        }
       
    }
}
