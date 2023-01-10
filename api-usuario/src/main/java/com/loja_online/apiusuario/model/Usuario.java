package com.loja_online.apiusuario.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.loja_online.apiusuario.dto.UsuarioDto;

import lombok.Data;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome; 
    private String cpf; 

    private String endereco;
    private String email;
    private String telefone;
    private LocalDate dataCadastro;

    public static Usuario convert(UsuarioDto usuarioDto) {
        Usuario user = new Usuario();
        user.setNome(usuarioDto.getNome());
        user.setEndereco(usuarioDto.getEndereco());
        user.setCpf(usuarioDto.getCpf());
        user.setEmail(usuarioDto.getEmail());
        user.setTelefone(usuarioDto.getTelefone());
        user.setDataCadastro(usuarioDto.getDataCadastro());
        return user;
    }
       

}
