package com.loja.online.api.repository.implementations;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.loja.online.api.model.Shop;
import com.loja.online.api.model.ShopReportDto;
import com.loja.online.api.repository.ReportRepository;

public class ReportRepositoryImpl implements ReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Shop> getShopByFilters(LocalDate dataInicio, LocalDate dataFim, Float valorMinimo)  {
        
        var queryStr = this.montarConsultaShopByFilters(dataInicio, dataFim, valorMinimo);
        Query query = this.entityManager.createQuery(queryStr);
        
        query.setParameter("dataInicio", dataInicio );

        if(dataFim != null) {
            query.setParameter("dataFim", dataFim);
        }
        if(valorMinimo != null) {
            query.setParameter("valorMinimo", valorMinimo);
        }
        
        
        @SuppressWarnings("unchecked")
        List<Shop> lista = query.getResultList();
        return  lista;

    }

    @Override
    public ShopReportDto getReportByData(LocalDate dataInicio, LocalDate dataFim) {
        var queryStr = this.montarConsultaReportByData(dataInicio, dataFim);
        Query query = this.entityManager.createNativeQuery(queryStr);
        query.setParameter("dataInicio", dataInicio);
        query.setParameter("dataFim", dataFim);

        ShopReportDto shopReportDto = (ShopReportDto) query.getSingleResult();

        return shopReportDto;
    }
    
    private String montarConsultaReportByData(LocalDate dataInicio, LocalDate dataFim) {
        var querySb = new StringBuilder();
        querySb.append("select count(sp.id), sum(sp.total), avg(sp.total) ");
        querySb.append("from shopping.shop sp ");
        querySb.append("where sp.data between :dataInicio and :dataFim");

        return querySb.toString();
    }

    private String montarConsultaShopByFilters(LocalDate dataInicio, LocalDate dataFim, Float valorMinimo) {
        var querySb = new StringBuilder();
        querySb.append("select s from shop s where s.data >= :dataInicio ");
        if(dataFim != null) {
            querySb.append("and s.data <= :dataFim ");
        }
        if(valorMinimo != null) {
            querySb.append("and s.total <= :valorMinimo");
        }

        return querySb.toString();
    }



}
