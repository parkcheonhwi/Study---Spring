package com.app.controller.mapper;

import com.app.controller.domain.CompanyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
@Slf4j
public class CompanyMapperTests {
    @Autowired
    private CompanyMapper companyMapper;

    @Test
    public void insertTest(){
        CompanyVO companyVO = new CompanyVO();
        companyVO.setName("한동석");
        companyVO.setGetToWorkDatetime(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        companyMapper.insert(companyVO);
    }
}
