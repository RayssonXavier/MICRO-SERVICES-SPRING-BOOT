package com.loja_online.apiusuario.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja_online.apiusuario.model.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long >{
    Usuario findByCpf(String cpf);
    List<Usuario> queryByNomeLike(String nome);
}
