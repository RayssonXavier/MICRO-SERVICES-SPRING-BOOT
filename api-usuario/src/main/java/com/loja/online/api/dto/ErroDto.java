package com.loja.online.api.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErroDto {
    private int status;
    private String mensagem;
    private LocalDateTime timestamp;
}
