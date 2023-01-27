package com.loja.online.api.exception.adevice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.loja.online.api.exception.CategoriaNotFoundException;
import com.shopping.client.DTO.ErroDto;



@ControllerAdvice(basePackages = "com.lojaonlineapiprodutos.controller")
public class CategoriaControllerAdvice {
    
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CategoriaNotFoundException.class)
    public ErroDto CategoriaNotFound(CategoriaNotFoundException categoriaNotFoundException) {
        ErroDto erroDto = new ErroDto();

        erroDto.setStatus(HttpStatus.NOT_FOUND.value());
        erroDto.setMessage("Categoria não encontrada");
        erroDto.setTimestamp(LocalDateTime.now().toString());

        return erroDto;
    }
}
