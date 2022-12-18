package com.lojaonlineapiprodutos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lojaonlineapiprodutos.dto.CategoriaDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name ="categoria")
@Table(name = "categoria")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;

    public static Categoria convert(CategoriaDto categoriaDto) {
        return new CategoriaBuilder()
                    .nome(categoriaDto.getNome())
                    .id(categoriaDto.getId()).build();
    }

}
