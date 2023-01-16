package com.loja.online.shopping.api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja.online.shopping.api.dto.ShopDto;
import com.loja.online.shopping.api.model.Shop;
import com.loja.online.shopping.api.repository.ShopRepository;

@Service
public class ShopService {
    @Autowired
    ShopRepository repository;

    public List<ShopDto> obterTodos() {
        return this.repository.findAll().stream().map(ShopDto::convert).collect(Collectors.toList());
    }

    public List<ShopDto> obterPeloUsuarioIdentificador(String identificador) {
        return this.repository.findAllByIdentificadorUsuario(identificador).stream().map(ShopDto::convert)
                .collect(Collectors.toList());
    }

    public List<ShopDto> obterPelaData(ShopDto shopDto) {
        return this.repository.findAllByDataGreaterThanEqual(shopDto.getData()).stream().map(ShopDto::convert)
                .collect(Collectors.toList());
    }

    public ShopDto obterPeloId(Long id) {
        Optional<Shop> shopOptional = this.repository.findById(id);
        if (shopOptional.isEmpty()) {
            return ShopDto.convert(shopOptional.get());
        }
        return null;
    }

    public ShopDto salvar(ShopDto shopDto) {
        shopDto.setTotal(
                shopDto.getItems().stream().map(item -> item.getPreco()).reduce(Float.intBitsToFloat(0), Float::sum));
        Shop shop = Shop.convert(shopDto);
        shop.setData(LocalDateTime.now());
        shop = this.repository.save(shop);        

        return ShopDto.convert(shop);
    }

}
