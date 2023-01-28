package com.loja.online.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.client.HttpClientErrorException;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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

    public final String BASE_URL = "http://localhost:8080/usuario/cpf/";
    public UsuarioDto obterPorCpf(String cpf, String chave) {
        try {
            
            var url = UriComponentsBuilder.fromHttpUrl(this.BASE_URL + cpf);
            url.queryParam("chave", chave).build();
            var resposnse = this.restTemplate.getForEntity(url.toUriString(), UsuarioDto.class);
            return resposnse.getBody();
        } catch (HttpClientErrorException e) {
            ErroDto erro = this.gson.fromJson(e.getResponseBodyAsString(), ErroDto.class);
            throw new UsuarioNotFoundException(erro.getMessage());
        }
       
    }
}
