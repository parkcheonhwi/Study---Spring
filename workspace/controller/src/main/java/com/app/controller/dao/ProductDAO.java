package com.app.controller.dao;

import com.app.controller.domain.ProductVO;
import com.app.controller.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
    private final ProductMapper productMapper;
//    상품 추가
    public void save(ProductVO productVO){
        productMapper.insert(productVO);
    }
}
