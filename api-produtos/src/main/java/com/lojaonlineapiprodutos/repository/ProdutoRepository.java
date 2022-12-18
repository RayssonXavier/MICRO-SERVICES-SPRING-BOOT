package com.lojaonlineapiprodutos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lojaonlineapiprodutos.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    @Query( value = "select p from produto p join categoria c on p.categoria.id = c.id where c.id = :categoriaId")
    public List<Produto> getProdutoByCategoria(@Param("categoriaId") long categoriaId);

    public Produto findByIdentificador(String identificador);
}
