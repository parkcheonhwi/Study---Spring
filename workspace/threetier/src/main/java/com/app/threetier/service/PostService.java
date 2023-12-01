package com.app.threetier.service;

import com.app.threetier.domain.PostVO;

import java.util.List;

public interface PostService {
//    게시글 목록
    public List<PostVO> getList();

//    게시글 작성
    public void write(PostVO postVO);

//    게시글 삭제(회원 탈퇴 시)
    public void deleteAll(Long memberId);
}
