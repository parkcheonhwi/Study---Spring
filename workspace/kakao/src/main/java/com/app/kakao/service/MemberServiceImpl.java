package com.app.kakao.service;

import com.app.kakao.dao.MemberDAO;
import com.app.kakao.domain.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;
    @Override
    public void join(MemberVO memberVO, Long id) {
//        1. 일반회원, 카카오회원 구분
        if(memberVO.getMemberKakaoProfileUrl() != null){ //카카오 로그인
            Optional<MemberVO> foundMember = getKaKaoMember(memberVO.getMemberKakaoEmail());
            if(id != null){
                memberVO.setId(id);
                delete(foundMember.get().getId());
                synchronize(memberVO);
                return;
            }
//          1-2. 최초 로그인 검사
            if(foundMember.isEmpty()){
                memberDAO.save(memberVO);
            }else{ // 이메일 정보가 있을 경우
                MemberVO member = foundMember.get();
//              1-3. 카카오회원일 경우 프사 검사
                if(member.getMemberProfileName() == null){// 전달받은 프사경로로 수정
//                    전달받은 카카오 프사로 업데이트
                    updateKaKaoProfile(memberVO);
                }
            }
        }else {
            memberVO.setMemberLoginCode("NORMAL");
            memberDAO.save(memberVO);
        }
    }

    @Override
    public Optional<MemberVO> login(MemberVO memberVO) {
        return memberDAO.login(memberVO);
    }

    @Override
    public Optional<MemberVO> getMember(Long id) {
        return memberDAO.findByMemberEmail(id);
    }

    @Override
    public Optional<MemberVO> getKaKaoMember(String memberKakaoEmail) {
        return memberDAO.findByKakaoEmail(memberKakaoEmail);
    }

    @Override
    public void updateKaKaoProfile(MemberVO memberVO) {
        memberDAO.setKaKaoProfile(memberVO);
    }

    @Override
    public void synchronize(MemberVO memberVO) {
        memberDAO.updateBySync(memberVO);
    }

    @Override
    public void delete(Long id) {
        memberDAO.delete(id);
    }
}
