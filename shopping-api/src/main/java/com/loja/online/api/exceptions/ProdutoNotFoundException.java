package com.loja.online.api.exceptions;

public class ProdutoNotFoundException extends RuntimeException{
    public ProdutoNotFoundException() {

    }

    public ProdutoNotFoundException(String mensagem) {
        super(mensagem);
    }
}
