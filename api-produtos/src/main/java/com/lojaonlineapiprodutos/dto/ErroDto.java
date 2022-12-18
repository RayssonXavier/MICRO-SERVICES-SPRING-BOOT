package com.lojaonlineapiprodutos.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErroDto {
    private int status;
    private String messagem;
    private LocalDateTime timestamp;
}
