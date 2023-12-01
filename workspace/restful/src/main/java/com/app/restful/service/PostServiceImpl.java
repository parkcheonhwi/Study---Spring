package com.app.restful.service;

import com.app.restful.dao.PostDAO;
import com.app.restful.domain.PostDTO;
import com.app.restful.domain.PostVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;

    @Override
    public List<PostDTO> getList() {
        return postDAO.findAll();
    }

    @Override
    public Optional<PostDTO> getPost(Long id) {
        return postDAO.findById(id);
    }

    @Override
    public void write(PostVO postVO) {
        postDAO.save(postVO);
    }

    @Override
    public void remove(Long id) {
        postDAO.deleteById(id);
    }

    @Override
    public void modify(PostVO postVO) {
        postDAO.update(postVO);
    }

    @Override
    public void removeByMemberId(Long memberId) {
        postDAO.deleteAllByMemberId(memberId);
    }
}
