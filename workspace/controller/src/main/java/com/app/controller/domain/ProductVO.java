package com.app.controller.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductVO {
    private Long id;
    private String productName;
    private String productBrand;
    private Integer productPrice;
    private Integer productStock;
}

