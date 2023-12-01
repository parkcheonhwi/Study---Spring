package com.app.controller.mapper;

import com.app.controller.domain.MemberVO;
import com.app.controller.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
//    회원가입
    public void insert(MemberVO memberVO);

//    로그인
    public Optional<MemberVO> select(MemberVO memberVO);
}
