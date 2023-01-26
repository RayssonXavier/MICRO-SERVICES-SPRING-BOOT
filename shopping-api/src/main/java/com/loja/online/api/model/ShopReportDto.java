package com.loja.online.api.model;

import lombok.Data;

@Data
public class ShopReportDto {
    private Integer quantidade;
    private Double total;
    private Double mean;
}
