package com.app.restful.service;

import com.app.restful.dao.MemberDAO;
import com.app.restful.dao.PostDAO;
import com.app.restful.domain.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;
    private final PostDAO postDAO;

    @Override
    public Optional<MemberVO> getMemberInfo(Long id) {
        return memberDAO.findById(id);
    }

    @Override
    public void withdraw(Long id) {
        postDAO.deleteAllByMemberId(id);
        memberDAO.deleteById(id);
    }
}
