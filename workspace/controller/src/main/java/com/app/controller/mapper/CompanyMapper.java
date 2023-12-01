package com.app.controller.mapper;

import com.app.controller.domain.CompanyVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMapper {
    public void insert(CompanyVO companyVO);
}
