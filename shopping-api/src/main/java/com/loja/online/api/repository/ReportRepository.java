package com.loja.online.api.repository;

import java.time.LocalDate;
import java.util.List;

import com.loja.online.api.model.Shop;
import com.loja.online.api.model.ShopReportDto;

public interface ReportRepository {
    public List<Shop> getShopByFilters(
        LocalDate dataInicio, LocalDate dataFim, Float valorMinimo);
    public ShopReportDto getReportByData(LocalDate dataInicio, LocalDate dataFim);    
}
