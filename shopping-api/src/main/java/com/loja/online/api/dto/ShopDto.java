package com.loja.online.api.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.loja.online.api.model.Shop;

import lombok.Data;

@Data
public class ShopDto {
    @NotBlank
    private String identificadorUsuario;
    @NotNull
    private float total;
    @NotNull
    private LocalDate data;
    @NotNull
    private String horas;

    @NotNull
    private List<ItemDto> items;

    public static ShopDto convert(Shop shop) {
        var shopDto = new ShopDto();
        shopDto.setData(shop.getData());
        shopDto.setHoras(shop.getHoras());
        shopDto.setIdentificadorUsuario(shop.getIdentificadorUsuario());
        shopDto.setTotal(shop.getTotal());
        shopDto.setItems(
            shop.getItems()
            .stream().map(ItemDto::convert).collect(Collectors.toList())
        );

        return shopDto;
    }
}
