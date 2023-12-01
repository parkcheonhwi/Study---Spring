package com.app.pagination.mapper;

import com.app.pagination.domain.Pagination;
import com.app.pagination.domain.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
//    게시글 추가
    public void insert(PostVO postVO);

//    게시글 전체 목록 조회
    public List<PostVO> selectAll(Pagination pagination);

//    게시글 전체 개수
    public int selectTotal();
}


















