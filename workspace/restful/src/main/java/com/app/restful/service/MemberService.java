package com.app.restful.service;

import com.app.restful.domain.MemberVO;

import java.util.Optional;

public interface MemberService {
//    회원 정보 조회
    public Optional<MemberVO> getMemberInfo(Long id);

//    회원 탈퇴
    public void withdraw(Long id);
}
