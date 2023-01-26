package com.loja.online.api.dto;

import javax.validation.constraints.NotNull;

import com.loja.online.api.model.Categoria;

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
