package com.lojaonlineapiprodutos.dto;

import javax.validation.constraints.NotNull;

import com.lojaonlineapiprodutos.model.Categoria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDto {
    @NotNull
    private long id;
    private String nome;

    public static CategoriaDto convert(Categoria categoria) {
        return new CategoriaDtoBuilder()
                    .nome(categoria.getNome())
                    .id(categoria.getId()).build();
    }
}
