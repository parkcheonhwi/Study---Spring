package com.app.restful.dao;

import com.app.restful.domain.PostDTO;
import com.app.restful.domain.PostVO;
import com.app.restful.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PostDAO {
    private final PostMapper postMapper;

    //    게시글 목록
    public List<PostDTO> findAll(){
        return postMapper.selectAll();
    }

    //    게시글 조회
    public Optional<PostDTO> findById(Long id){
        return postMapper.select(id);
    }

    //    게시글 작성
    public void save(PostVO postVO){
        log.info(postVO.toString());
        postMapper.insert(postVO);
    }

    //    게시글 삭제
    public void deleteById(Long id){
        postMapper.delete(id);
    }

    //    게시글 수정
    public void update(PostVO postVO){
        postMapper.update(postVO);
    }

//    회원 탈퇴 시 게시글 전체 삭제
    public void deleteAllByMemberId(Long memberId){
        postMapper.deleteAll(memberId);
    }
}
