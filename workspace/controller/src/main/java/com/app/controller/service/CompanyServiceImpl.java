package com.app.controller.service;

import com.app.controller.dao.CompanyDAO;
import com.app.controller.domain.CompanyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyDAO companyDAO;

    @Override
    public void register(CompanyVO companyVO) {
        companyDAO.save(companyVO);
    }
}
