package com.loja.online.api.exceptions.advice;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.loja.online.api.exceptions.ProdutoNotFoundException;
import com.loja.online.api.exceptions.UsuarioNotFoundException;
import com.shopping.client.DTO.ErroDto;

@RestControllerAdvice(basePackages = "com.loja.online.api.controller")
public class ShopControllerAdvice {
    
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UsuarioNotFoundException.class)
    public ErroDto usuarioNotFound(UsuarioNotFoundException ex) {
        ErroDto erroDto = new ErroDto();
        erroDto.setStatus(HttpStatus.NOT_FOUND.value());
        erroDto.setMessage(ex.getMessage());
        erroDto.setTimestamp(LocalDateTime.now().toString());

        return erroDto;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProdutoNotFoundException.class)
    public ErroDto produtoNotFound(ProdutoNotFoundException ex) {
        ErroDto erroDto = new ErroDto();
        erroDto.setStatus(HttpStatus.NOT_FOUND.value());
        erroDto.setMessage(ex.getMessage());
        erroDto.setTimestamp(LocalDateTime.now().toString());
        return erroDto;
    }
}
