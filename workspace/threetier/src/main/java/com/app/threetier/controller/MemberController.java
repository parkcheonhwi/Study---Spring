package com.app.threetier.controller;

import com.app.threetier.domain.MemberVO;
import com.app.threetier.mapper.MemberMapper;
import com.app.threetier.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
// 최상위 경로를 설정하여 컨트롤러를 구분한다.
@RequestMapping("/member/*")
public class MemberController {
    private final MemberService memberService;
    private final HttpSession session;
    
//    회원가입 페이지 이동(GET)
    @GetMapping("join")
//    화면에서 key를 해당 객체의 필드명과 동일하게 맞추기 위해서 비어있는 객체를 전송한다.
    public void goToJoinForm(MemberVO memberVO){;}
    
//    회원가입 완료(POST)
    @PostMapping("join")
//    사용자가 입력한 정보를 MemberVO 객체의 필드명과 동일한 key로 받는다.
    public RedirectView join(MemberVO memberVO){
//        전달받은 정보를 DBMS에 INSERT한다.
        memberService.join(memberVO);
//        redirect방식으로 post/list 컨트롤러로 이동한다.
        return new RedirectView("/member/login");
    }
    
//    로그인 페이지 이동
    @GetMapping("login")
    public void goToLoginForm(MemberVO memberVO){;}

//    로그인 완료
    @PostMapping("login")
    public RedirectView login(MemberVO memberVO, RedirectAttributes redirectAttributes){
        Optional<MemberVO> foundMember = memberService.login(memberVO);
        if(foundMember.isPresent()){
            session.setAttribute("member", foundMember.get());
            return new RedirectView("/post/list");
        }
//        쿼리스트링으로 파라미터가 전송되며, 컨트롤러 매개변수에 매핑되어 전달된다.
//        redirectAttributes.addAttribute("key", "value");

//        session의 flash영역에 저장되고, 화면에 도착하기 전 초기화된 request객체에 저장된 뒤 flash영역은 초기화된다.
        redirectAttributes.addFlashAttribute("login", false);
        return new RedirectView("/member/login");
    }

//    로그아웃
    @GetMapping("logout")
    public RedirectView logout(){
        session.invalidate();
        return new RedirectView("/member/login");
    }

//    회원탈퇴
    @GetMapping("withdraw")
    public RedirectView withdraw(){
        memberService.withdraw(((MemberVO)session.getAttribute("member")).getId());
        return new RedirectView("/member/login");
    }
}
