package com.loja.online.api.exception.adevice;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.loja.online.api.exception.ProdutoNotFoundException;
import com.shopping.client.DTO.ErroDto;

@ControllerAdvice(basePackages = "com.loja.online.api.controller")
public class ProdutoControllerAdvice {
    
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProdutoNotFoundException.class)
    public ErroDto produtoNotFound(ProdutoNotFoundException produtoNotFoundException) {
        ErroDto erroDto = new ErroDto();
        erroDto.setStatus(HttpStatus.NOT_FOUND.value());
        erroDto.setMessage("Produto não encontrado");
        erroDto.setTimestamp(LocalDateTime.now().toString());
        return erroDto;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErroDto camposInvalidos(MethodArgumentNotValidException ex) {
        ErroDto erroDto = new ErroDto();
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErro = bindingResult.getFieldErrors();

        StringBuilder sb = new StringBuilder("Valor inválido para os campos: ");

        fieldErro.forEach((field) -> {
            sb.append(" ");
            sb.append(field.getField());
        });

        erroDto.setStatus(HttpStatus.BAD_REQUEST.value());
        erroDto.setMessage(sb.toString());
        erroDto.setTimestamp(LocalDateTime.now().toString());

        return erroDto;
    }
}
