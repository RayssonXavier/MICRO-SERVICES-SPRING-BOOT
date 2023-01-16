package com.loja.online.shopping.api.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.loja.online.shopping.api.model.Shop;

import lombok.Data;

@Data
public class ShopDto {
    @NotBlank
    private String identificadorUsuario;
    @NotNull
    private float total;
    @NotNull
    private LocalDateTime data;
    @NotNull
    private List<ItemDto> items;

    public static ShopDto convert(Shop shop) {
        var shopDto = new ShopDto();
        shopDto.setData(shop.getData());
        shopDto.setIdentificadorUsuario(shop.getIdentificadorUsuario());
        shopDto.setTotal(shop.getTotal());
        shopDto.setItems(
            shop.getItems()
            .stream().map(ItemDto::convert).collect(Collectors.toList())
        );

        return shopDto;
    }
}
