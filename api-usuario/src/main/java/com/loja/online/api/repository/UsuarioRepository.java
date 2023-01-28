package com.loja.online.api.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja.online.api.model.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long >{
    Usuario findByCpfAndChave(String cpf, String chave);
    List<Usuario> queryByNomeLike(String nome);
}
