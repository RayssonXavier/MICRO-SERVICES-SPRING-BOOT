package com.loja.online.shopping.api.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja.online.shopping.api.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    public List<Shop> findAllByIdentificadorUsuario(String identificadoUsuario);
    public List<Shop> findAllByTotalGreaterThan(Float total);
    public List<Shop> findAllByDataGreaterThanEquals(LocalDateTime data);
}
