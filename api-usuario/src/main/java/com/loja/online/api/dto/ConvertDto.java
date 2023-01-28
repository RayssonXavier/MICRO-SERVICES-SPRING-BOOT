package com.loja.online.api.dto;

import com.loja.online.api.model.Usuario;

public class ConvertDto{
    

    public static UsuarioDto convert(Usuario usuario) {
        var usuarioDto = new UsuarioDto();
        usuarioDto.setCpf(usuario.getCpf());
        usuarioDto.setDataCadastro(usuario.getDataCadastro());
        usuarioDto.setEmail(usuario.getEmail());
        usuarioDto.setEndereco(usuario.getEndereco());
        usuarioDto.setNome(usuario.getNome());
        usuarioDto.setTelefone(usuario.getTelefone());
        usuarioDto.setChave(usuario.getChave());
        return usuarioDto;
    }
}