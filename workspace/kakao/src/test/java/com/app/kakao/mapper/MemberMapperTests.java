package com.app.kakao.mapper;

import com.app.kakao.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberMapperTests {
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void insertTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test@gmail.com");
        memberVO.setMemberPassword("1234");
        memberVO.setMemberName("한동석");
        memberVO.setMemberLoginCode("NORMAL");

        memberMapper.insert(memberVO);
    }
}
