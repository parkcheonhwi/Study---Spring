package com.app.restful.dao;

import com.app.restful.domain.MemberVO;
import com.app.restful.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

//    회원 정보 조회
    public Optional<MemberVO> findById(Long id){
        return memberMapper.select(id);
    }

//    회원 탈퇴
    public void deleteById(Long id){
        memberMapper.delete(id);
    }
}
