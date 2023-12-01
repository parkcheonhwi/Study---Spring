package com.app.restful.mapper;

import com.app.restful.domain.PostDTO;
import com.app.restful.domain.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {
//    게시글 목록
    public List<PostDTO> selectAll();

//    게시글 조회
    public Optional<PostDTO> select(Long id);

//    게시글 작성
    public void insert(PostVO postVO);

//    게시글 삭제
    public void delete(Long id);

//    게시글 수정
    public void update(PostVO postVO);

//    회원 탈퇴 시 해당 게시글 전체 삭제
    public void deleteAll(Long memberId);
}
