package com.loja.online.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.loja.online.api.exceptions.ProdutoNotFoundException;
import com.google.gson.Gson;
import com.shopping.client.DTO.ErroDto;
import com.shopping.client.DTO.ProdutoDto;

@Service
public class ProdutoService {
    
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Gson gson;

    public ProdutoDto obterProdutoPorIdentificador(String identificador) {
        try {
            var url = "http://localhost:8081/produto/identificador/"+identificador;
            var resposnse = this.restTemplate.getForEntity(url, ProdutoDto.class);
            return resposnse.getBody();
        } catch (HttpClientErrorException e) {
            ErroDto erro = this.gson.fromJson(e.getResponseBodyAsString(), ErroDto.class);
            throw new ProdutoNotFoundException(erro.getMessage());
        }
        
    }
}
