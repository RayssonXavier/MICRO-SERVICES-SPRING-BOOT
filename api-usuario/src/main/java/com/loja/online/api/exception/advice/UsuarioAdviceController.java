package com.loja.online.api.exception.advice;

import java.time.LocalDateTime;
import java.util.List;
import com.shopping.client.DTO.ErroDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.loja.online.api.exception.UsuarioNotFoundException;

@RestControllerAdvice(basePackages = "com.loja.online.api.controller")
public class UsuarioAdviceController {
    
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UsuarioNotFoundException.class)
    public ErroDto usuarioNotFound(UsuarioNotFoundException ex) {
        ErroDto erroDto = new ErroDto();
        erroDto.setStatus(HttpStatus.NOT_FOUND.value());
        erroDto.setMessage("Usuario não encontrado");
        erroDto.setTimestamp(LocalDateTime.now().toString());
        return erroDto;
    }
   

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErroDto usuarioNotFound(MethodArgumentNotValidException ex) {
        ErroDto erroDto = new ErroDto();
        
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        
        StringBuilder sb = new StringBuilder("Valor inválido para os campos: "); 
        fieldErrors.forEach((fieldErro) -> {
            sb.append(" ");
            sb.append(fieldErro.getField());
        });
        erroDto.setStatus(HttpStatus.BAD_REQUEST.value());
        erroDto.setMessage(sb.toString());
        erroDto.setTimestamp(LocalDateTime.now().toString());

        return erroDto;
    }
}
