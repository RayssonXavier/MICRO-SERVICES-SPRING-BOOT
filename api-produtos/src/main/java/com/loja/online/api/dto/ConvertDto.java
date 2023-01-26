package com.loja.online.api.dto;

import com.loja.online.api.model.Categoria;
import com.loja.online.api.model.Produto;

public class ConvertDto {
    
    public static ProdutoDto convert(Produto produto) {
        var produtoDto = new ProdutoDto();
        if(produto.getCategoria() != null) {
            produtoDto.setCategoriaDto(convert(produto.getCategoria()));
        }
        produtoDto.setDescricao(produto.getDescricao());
        produtoDto.setIdentificador(produto.getDescricao());
        produtoDto.setNome(produto.getNome());
        produtoDto.setPreco(produto.getPreco());

        return produtoDto;
    }

    public static CategoriaDto convert(Categoria categoria) {
        var categoriaDto = new CategoriaDto();
        categoriaDto.setId(categoria.getId());
        categoriaDto.setNome(categoria.getNome());

        return categoriaDto;
    }
}
