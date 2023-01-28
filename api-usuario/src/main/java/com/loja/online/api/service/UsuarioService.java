package com.loja.online.api.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja.online.api.dto.UsuarioDto;
import com.loja.online.api.exception.UsuarioNotFoundException;
import com.loja.online.api.model.Usuario;
import com.loja.online.api.repository.UsuarioRepository;

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

    public UsuarioDto obterPeloCpf(String cpf, String chave ) {
        var usuario = this.repository.findByCpfAndChave(cpf, chave);
        if(usuario != null) {
            return UsuarioDto.convert(usuario);
        }
       throw new UsuarioNotFoundException();
    }

    public UsuarioDto obterPeloId(long id) {
        var usuario = this.repository.findById(id);
        if(usuario.isPresent()) {
            return UsuarioDto.convert(usuario.get());
        }
        throw new UsuarioNotFoundException();
    }

    public UsuarioDto salvar(UsuarioDto usuarioDto) {
        usuarioDto.setChave(UUID.randomUUID().toString());
        var usuario = this.repository.save(Usuario.convert(usuarioDto));
        return UsuarioDto.convert(usuario);
    }

    public UsuarioDto deletar(long id) {
        var usuario = this.repository.findById(id);
        if(usuario.isPresent()) {
            this.repository.delete(usuario.get());
            return UsuarioDto.convert(usuario.get());
        }

        throw new UsuarioNotFoundException();
    }

    public List<UsuarioDto> filtroPelaParteNome(String nome) {
        var usuarios = this.repository.queryByNomeLike(nome);
        return usuarios.stream()
            .map(UsuarioDto::convert)
            .collect(Collectors.toList());
            
    }
}
