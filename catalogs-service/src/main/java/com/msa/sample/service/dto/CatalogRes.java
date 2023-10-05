package com.msa.sample.service.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.msa.sample.domain.Catalog;

import lombok.*;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatalogRes {
    private String productId;
    private String productName;
    private Integer unitPrice;
    private Integer totalPrice;
    private LocalDateTime createdAt;
    
    public CatalogRes(Catalog catalog) {
    	this.createdAt = catalog.getCreatedAt();
    	this.productId = catalog.getProductId();
    	this.unitPrice = catalog.getUnitPrice();
    	this.productName = catalog.getProductName();
    	this.totalPrice = null;
    }
}
