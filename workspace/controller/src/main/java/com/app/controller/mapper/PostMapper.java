package com.app.controller.mapper;

import com.app.controller.domain.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
//    게시글 목록
    public List<PostVO> selectAll();

//    게시글 작성
}
