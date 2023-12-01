package com.app.kakao.dao;

import com.app.kakao.domain.MemberVO;
import com.app.kakao.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MemberDAO {
    private final MemberMapper memberMapper;
//    회원가입
    public void save(MemberVO memberVO){
        memberMapper.insert(memberVO);
    }

//    로그인
    public Optional<MemberVO> login(MemberVO memberVO){
        return memberMapper.selectByLogin(memberVO);
    }

//    회원 정보 조회
    public Optional<MemberVO> findByMemberEmail(Long id){
        return memberMapper.select(id);
    }

//    카카오 회원 정보 조회
    public Optional<MemberVO> findByKakaoEmail(String memberKakaoEmail){
        return memberMapper.selectKaKao(memberKakaoEmail);
    }

//    카카오 프사 수정
    public void setKaKaoProfile(MemberVO memberVO){
        memberMapper.updateKaKaoProfile(memberVO);
    }

//    카카오 연동하기
    public void updateBySync(MemberVO memberVO){
        memberMapper.updateBySync(memberVO);
    }

//    회원 삭제
    public void delete(Long id){
        memberMapper.delete(id);
    }
}
