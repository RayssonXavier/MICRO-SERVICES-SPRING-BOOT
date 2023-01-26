package com.loja.online.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.loja.online.api.model.Item;

import lombok.Data;

@Data
public class ItemDto {

    @NotBlank
    private String identificadoProduto;
    @NotNull
    private Float preco;

    public static ItemDto convert(Item item) {
        var itemDto = new ItemDto();
        itemDto.setIdentificadoProduto(item.getIdentificadoProduto());
        itemDto.setPreco(item.getPreco());

        return itemDto;
    }
}
