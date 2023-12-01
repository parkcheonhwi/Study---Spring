package com.app.controller.mapper;

import com.app.controller.domain.ProductVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
//    상품 추가
    public void insert(ProductVO productVO);
}
