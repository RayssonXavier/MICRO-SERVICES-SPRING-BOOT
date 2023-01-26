package com.loja.online.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.loja.online.api.dto.ProdutoDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name ="produto")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String identificador;
    private String descricao;
    private Float preco;

    @ManyToOne()
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public static Produto convert(ProdutoDto produtoDto) {
        return new ProdutoBuilder()
                    .nome(produtoDto.getNome())
                    .descricao(produtoDto.getDescricao())
                    .identificador(produtoDto.getIdentificador())
                    .preco(produtoDto.getPreco())
                    .categoria(produtoDto.getCategoriaDto() != null ? 
                        Categoria.convert(produtoDto.getCategoriaDto()) : null ).build();
    }
}
