package com.app.kakao.controller;

import com.app.kakao.domain.MemberVO;
import com.app.kakao.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/*")
@Slf4j
public class MemberController {
    private final MemberService memberService;

//    회원가입
    @GetMapping("join")
    public void goToJoinForm(MemberVO memberVO){;}

    @PostMapping("join")
    public RedirectView join(MemberVO memberVO){
        memberService.join(memberVO, null);
        return new RedirectView("/member/login");
    }

//    로그인
    @GetMapping("login")
    public void goToLoginForm(MemberVO memberVO){;}

    @PostMapping("login")
    public RedirectView login(MemberVO memberVO, HttpSession session, RedirectAttributes redirectAttributes){
        Optional<MemberVO> foundMember = memberService.login(memberVO);
        if(foundMember.isPresent()){
            session.setAttribute("member", foundMember.get());
            return new RedirectView("/member/mypage");
        }
        return new RedirectView("/member/login");
    }

//    마이페이지
    @GetMapping("mypage")
    public void goToMyPageForm(Model model){;}

//    로그아웃
    @GetMapping("logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/member/login");
    }

}



















