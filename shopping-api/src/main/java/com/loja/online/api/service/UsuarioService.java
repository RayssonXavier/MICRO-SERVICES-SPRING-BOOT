package com.loja.online.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shopping.client.DTO.UsuarioDto;

@Service
public class UsuarioService {
    
    @Autowired
    RestTemplate restTemplate;

    public UsuarioDto obterPorCpf(String cpf) {
        var url = "http://localhost:8080/usuario/cpf/"+cpf;
        var resposnse = this.restTemplate.getForEntity(url, UsuarioDto.class);
        
        return resposnse.getBody();
    }
}
