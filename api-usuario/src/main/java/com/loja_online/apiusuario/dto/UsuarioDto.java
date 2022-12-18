package com.loja_online.apiusuario.dto;

import java.time.LocalDate;

import com.loja_online.apiusuario.model.Usuario;

import lombok.Data;

@Data
public class UsuarioDto {
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private LocalDate dataCadastro; 

    public static UsuarioDto convert(Usuario user) {
        UsuarioDto userDTO = new UsuarioDto();
        userDTO.setNome(user.getNome());
        userDTO.setEndereco(user.getEndereco());
        userDTO.setCpf(user.getCpf());
        userDTO.setEmail(user.getEmail());
        userDTO.setTelefone(user.getTelefone());
        userDTO.setDataCadastro(user.getDataCadastro());
        return userDTO;
    }
}
