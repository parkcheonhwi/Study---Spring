package com.app.controller.mapper;

import com.app.controller.domain.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostMapperTests {
    @Autowired
    private PostMapper postMapper;

    @Test
    public void selectAllTest(){
        postMapper.selectAll().stream().map(PostVO::toString).forEach(log::info);
    }
}
