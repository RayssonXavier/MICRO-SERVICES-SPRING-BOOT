package com.loja.online.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shopping.client.DTO.ProdutoDto;

@Service
public class ProdutoService {
    
    @Autowired
    RestTemplate restTemplate;

    public ProdutoDto obterProdutoPorIdentificador(String identificador) {
        var url = "http://localhost:8081/produto/"+identificador;
        var resposnse = this.restTemplate.getForEntity(url, ProdutoDto.class);
        return resposnse.getBody();
    }
}
