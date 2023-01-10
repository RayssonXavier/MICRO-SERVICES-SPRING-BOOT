package com.loja_online.apiusuario.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErroDto {
    private int status;
    private String mensagem;
    private LocalDateTime timestamp;
}
