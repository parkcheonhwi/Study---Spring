package com.app.controller.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class GoodsVO {
    private String goodsName;
    private int goodsPrice;
}
