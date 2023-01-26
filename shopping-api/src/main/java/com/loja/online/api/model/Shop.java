package com.loja.online.api.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.loja.online.api.dto.ShopDto;

import lombok.Data;

@Entity(name = "shop")
@Data
public class Shop {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String identificadorUsuario;
    private float total;
    private LocalDate data;
    private LocalTime horas;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "item", 
        joinColumns =  @JoinColumn (name = "shop_id"))
    private List<Item> items;
    
    public static Shop convert(ShopDto shopDto) {
        var shop = new Shop();
        shop.setData(shopDto.getData());
        shop.setIdentificadorUsuario(shopDto.getIdentificadorUsuario());
        shop.setTotal(shopDto.getTotal());
        shop.setItems(
            shopDto.getItems()
            .stream().map(Item::convert)
            .collect(Collectors.toList()));
        return shop;    
    }
}
