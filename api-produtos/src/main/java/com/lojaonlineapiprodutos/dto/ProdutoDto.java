package com.lojaonlineapiprodutos.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.lojaonlineapiprodutos.model.Produto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String identificador;
    @NotBlank
    private String descricao;
    @NotNull
    private Float preco;
    @NotNull
    private CategoriaDto categoriaDto;

    public static ProdutoDto convert(Produto produto) {
        return new ProdutoDtoBuilder()
                    .nome(produto.getNome())
                    .descricao(produto.getDescricao())
                    .identificador(produto.getIdentificador())
                    .preco(produto.getPreco())
                    .categoriaDto(produto.getCategoria() != null ? 
                    CategoriaDto.convert(produto.getCategoria()) : null ).build();
    }
}
