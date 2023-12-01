package com.app.controller.service;

import com.app.controller.dao.ProductDAO;
import com.app.controller.domain.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;

    @Override
    public void write(ProductVO productVO) {
        productDAO.save(productVO);
    }
}
