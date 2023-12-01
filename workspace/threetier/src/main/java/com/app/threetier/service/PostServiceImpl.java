package com.app.threetier.service;

import com.app.threetier.domain.PostVO;
import com.app.threetier.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;

//    게시글 목록
    @Override
    public List<PostVO> getList() {
        return postDAO.findAll();
    }

//    게시글 작성
    @Override
    public void write(PostVO postVO) {
        postDAO.save(postVO);
    }

    //    게시글 삭제(회원 탈퇴 시)
    @Override
    public void deleteAll(Long memberId) {
        postDAO.deleteAllByMemberId(memberId);
    }
}
