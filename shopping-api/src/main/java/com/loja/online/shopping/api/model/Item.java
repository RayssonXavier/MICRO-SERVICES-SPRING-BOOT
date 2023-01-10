package com.loja.online.shopping.api.model;

import javax.persistence.Embeddable;

import com.loja.online.shopping.api.dto.ItemDto;

import lombok.Data;

@Data
@Embeddable
public class Item {
    private String identificadoProduto;
    private Float preco;

    public static Item convert(ItemDto itemDto) {
        var item = new Item();
        item.identificadoProduto = itemDto.getIdentificadoProduto();
        item.preco = itemDto.getPreco();
        return item;
    }
}
