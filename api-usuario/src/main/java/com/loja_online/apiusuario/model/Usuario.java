package com.loja_online.apiusuario.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.loja_online.apiusuario.dto.UsuarioDto;

import lombok.Data;

@Entity
@Data
@NamedQueries(
    @NamedQuery(
        name  = "CONSULTA_POR_CPF",
        query = "SELECT FROM Usuario u WHERE u.cpf = :cpf"
    )
)
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
