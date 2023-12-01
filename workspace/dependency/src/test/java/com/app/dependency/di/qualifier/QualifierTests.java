package com.app.dependency.di.qualifier;

import com.app.dependency.di.qualifier.task.Resturant;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class QualifierTests {
//    @Qualifier
//    Spring Container에 등록된 Bean객체 중 동일한 타입의 Bean이 여러 개 있다면,
//    이 때 @Qualifier를 사용해서 주입 받을 객체를 정할 수 있다.
    @Autowired
//    @Qualifier("laptop")
    private Computer computer;

    @Autowired @Qualifier("vips")
    private Resturant resturant;
    @Test
    public void computerTest(){
        log.info("===================");
        log.info("{}", computer);
        log.info("===================");
    }
    @Test
    public void resturantTest(){
        log.info("===================");
        log.info("{}", resturant);
        log.info("===================");
    }
}
