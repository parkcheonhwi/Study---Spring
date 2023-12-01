package com.app.pagination.mapper;

import com.app.pagination.domain.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
@Slf4j
public class PostMapperTests {
    @Autowired
    private PostMapper postMapper;


    @Test
    public void insertTest(){
        Random random = new Random();
        PostVO postVO = null;
        int idx = 0;
        for (int i=0; i<356; i++){
            postVO = new PostVO();
            idx = random.nextInt(356) + 1;
            postVO.setPostTitle("테스트 제목" + idx);
            postVO.setPostContent("테스트 내용" + idx);
            postVO.setPostWriter("작성자" + idx);
            postMapper.insert(postVO);
        }
    }
}
