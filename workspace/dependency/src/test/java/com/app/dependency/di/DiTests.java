package com.app.dependency.di;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class DiTests {

    @Autowired
    private Coding coding;

    @Autowired
    private Food food;

    @Test
    public void codingTest(){
//        지역에 선언된 객체는 @Autowired를 사용할 수 없다.
//        Coding coding = new Coding();
        log.info("----------------------");
        log.info("{}", coding);
        log.info("{}", coding.getComputer());
        log.info("----------------------");
    }

    @Test
    public void foodTest(){
        log.info("----------------------");
        log.info("{}", food);
        log.info("{}", food.getKnife());
        log.info("----------------------");
    }
}














