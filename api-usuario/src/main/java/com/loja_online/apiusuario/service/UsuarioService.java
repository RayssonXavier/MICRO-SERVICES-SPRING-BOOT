package com.loja_online.apiusuario.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja_online.apiusuario.dto.UsuarioDto;
import com.loja_online.apiusuario.model.Usuario;
import com.loja_online.apiusuario.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repository;

    public List<UsuarioDto> obterTodos() {
        var usuarios = this.repository.findAll();

       return usuarios
        .stream()
        .map(UsuarioDto :: convert)
        .collect(Collectors.toList());
    }

    public UsuarioDto obterPeloCpf(String cpf) {
        var usuario = this.repository.findByCpf(cpf);
        return UsuarioDto.convert(usuario);
    }

    public UsuarioDto obterPeloId(long id) {
        var usuario = this.repository.findById(id);
        if(usuario.isPresent()) {
            return UsuarioDto.convert(usuario.get());
        }
        return null;
    }

    public UsuarioDto salvar(UsuarioDto usuarioDto) {
        var usuario = this.repository.save(Usuario.convert(usuarioDto));
        return UsuarioDto.convert(usuario);
    }

    public UsuarioDto deletar(long id) {
        var usuario = this.repository.findById(id);
        if(usuario.isPresent()) {
            this.repository.delete(usuario.get());
            return UsuarioDto.convert(usuario.get());
        }

        return null;
    }

    public List<UsuarioDto> filtroPelaParteNome(String nome) {
        var usuarios = this.repository.queryByNomeLike(nome);
        return usuarios.stream()
            .map(UsuarioDto::convert)
            .collect(Collectors.toList());
            
    }
}
