package com.app.controller.dao;

import com.app.controller.domain.CompanyVO;
import com.app.controller.mapper.CompanyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CompanyDAO {
    private final CompanyMapper companyMapper;

//    추가
    public void save(CompanyVO companyVO){
        companyMapper.insert(companyVO);
    }
}
