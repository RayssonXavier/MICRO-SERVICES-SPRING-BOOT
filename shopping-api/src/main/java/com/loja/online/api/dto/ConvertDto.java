package com.loja.online.api.dto;

import java.util.stream.Collectors;

import com.loja.online.api.model.Item;
import com.loja.online.api.model.Shop;

public class ConvertDto {
    
    public static ShopDto convert(Shop shop) {
        var shopDto = new ShopDto();
        shopDto.setData(shop.getData());
        shopDto.setHoras(shop.getHoras());
        shopDto.setIdentificadorUsuario(shop.getIdentificadorUsuario());
        shopDto.setTotal(shop.getTotal());
        shopDto.setItems(
            shop.getItems()
            .stream()
            .map(ConvertDto::convert)
            .collect(Collectors.toList()));

        return shopDto;
    }

    public static ItemDto convert(Item item) {
        var itemDto = new ItemDto();
        itemDto.setIdentificadoProduto(item.getIdentificadoProduto());
        itemDto.setPreco(item.getPreco());
        
        return itemDto;
    }
}
