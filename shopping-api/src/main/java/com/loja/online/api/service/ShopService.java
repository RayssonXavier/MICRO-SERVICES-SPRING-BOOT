package com.loja.online.api.service;


import java.time.LocalDate;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja.online.api.dto.ItemDto;
import com.loja.online.api.dto.ShopDto;
import com.loja.online.api.exceptions.UsuarioNotFoundException;
import com.loja.online.api.model.Shop;
import com.loja.online.api.repository.ShopRepository;


@Service
public class ShopService {

    @Autowired
    ShopRepository repository;

    @Autowired
    ProdutoService produtoService;

    @Autowired
    UsuarioService usuarioService;

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

    public ShopDto salvar(ShopDto shopDto, String chave) throws UsuarioNotFoundException {
        this.usuarioService
            .obterPorCpf(shopDto.getIdentificadorUsuario(), chave );

        this.atribuirPrecoItens(shopDto.getItems());         
        shopDto.setTotal(
                shopDto.getItems().stream().map(item -> item.getPreco()).reduce(Float.intBitsToFloat(0), Float::sum));
        Shop shop = Shop.convert(shopDto);
        shop.setData(LocalDate.now());
        shop.setHoras(LocalTime.now().toString());
        shop = this.repository.save(shop);

        return ShopDto.convert(shop);
     }

    public List<ShopDto> obterShopDoFiltro(LocalDate dataInicio, LocalDate dataFim, Float valorMinimo) {
        var shoList = this.repository.getShopByFilters(dataInicio, dataFim, valorMinimo);    
        return shoList.stream().map(ShopDto::convert).collect(Collectors.toList());
    }

    private boolean atribuirPrecoItens(List<ItemDto> itens) {
        for(var item: itens) {
            var produtoDto = this.produtoService.obterProdutoPorIdentificador(item.getIdentificadoProduto());
            if( produtoDto == null) {
                return false;
            }
            
            item.setPreco(produtoDto.getPreco());
        }
        return true; 
    } 

}
