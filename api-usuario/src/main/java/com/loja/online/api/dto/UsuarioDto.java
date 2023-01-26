package com.loja.online.api.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.loja.online.api.model.Usuario;

import lombok.Data;

@Data
public class UsuarioDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @NotBlank
    private String endereco;
    @NotBlank
    private String email;
    @NotBlank
    private String telefone;

    private LocalDate dataCadastro = LocalDate.now(); 

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