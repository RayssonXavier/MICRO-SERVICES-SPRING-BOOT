package com.loja.online.api.exceptions;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException() {
        
    }
    
    public UsuarioNotFoundException(String message) {
        super(message);
    }
}
