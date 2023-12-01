package com.app.controller.controller.api;

import com.app.controller.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests/api/*")
@Slf4j
public class TestAPI {

    @GetMapping("user/{id}")
    public MemberVO test(@PathVariable("id") Long id){
        log.info("요청 들어옴!");
        MemberVO memberVO = new MemberVO();
        memberVO.setId(id);
        memberVO.setMemberName("한동석");
        memberVO.setMemberEmail("hds1234@gmail.com");
        memberVO.setMemberPassword("1234");
        return memberVO;
    }
}
