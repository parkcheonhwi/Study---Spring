package com.app.threetier.mapper;

import com.app.threetier.domain.MemberVO;
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
    public void selectTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("tedhan1204@gmail.com");
        memberVO.setMemberPassword("1234");
        memberMapper.select(memberVO).map(MemberVO::toString).ifPresent(log::info);
    }

    @Test
    public void insertTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test@gmail.com");
        memberVO.setMemberPassword("9999");
        memberVO.setMemberName("테스트");

        memberMapper.insert(memberVO);
    }
}
