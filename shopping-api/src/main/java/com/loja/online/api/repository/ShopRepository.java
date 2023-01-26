package com.loja.online.api.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja.online.api.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>, ReportRepository {
    public List<Shop> findAllByIdentificadorUsuario(String identificadoUsuario);
    public List<Shop> findAllByTotalGreaterThan(Float total);
    public List<Shop> findAllByDataGreaterThanEqual(LocalDate data);
}
