package com.app.threetier.mapper;

import com.app.threetier.domain.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
//    게시글 목록
    public List<PostVO> selectAll();

//    게시글 작성
    public void insert(PostVO postVO);

//    게시글 삭제(회원 탈퇴 시)
    public void deleteAll(Long memberId);
}
