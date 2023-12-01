package com.app.restful.mapper;

import com.app.restful.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
//    회원 정보 조회
    public Optional<MemberVO> select(Long id);

//    회원 탈퇴
    public void delete(Long id);
}
