package com.app.kakao.service;

import com.app.kakao.domain.MemberVO;

import java.util.Optional;

public interface MemberService {
//    회원가입
    public void join(MemberVO memberVO, Long id);

//    로그인
    public Optional<MemberVO> login(MemberVO memberVO);

//    회원 정보 조회
    public Optional<MemberVO> getMember(Long id);

//    카카오 회원 정보 조회
    public Optional<MemberVO> getKaKaoMember(String memberKakaoEmail);

//    카카오 프사 수정
    public void updateKaKaoProfile(MemberVO memberVO);
    
//    카카오 연동하기
    public void synchronize(MemberVO memberVO);

//    회원 삭제
    public void delete(Long id);
}
