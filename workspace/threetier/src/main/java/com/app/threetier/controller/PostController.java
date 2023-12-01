package com.app.threetier.controller;

import com.app.threetier.domain.MemberVO;
import com.app.threetier.domain.PostVO;
import com.app.threetier.mapper.PostMapper;
import com.app.threetier.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/post/*")
public class PostController {
    private final PostService postService;

    @GetMapping("list")
    public void goToPostList(Model model){
        model.addAttribute("posts", postService.getList());
    }

    @GetMapping("write")
    public void goToWriteForm(PostVO postVO){;}

    @PostMapping
    public RedirectView write(PostVO postVO, HttpSession session){
        postVO.setMemberId(((MemberVO)session.getAttribute("member")).getId());
        postService.write(postVO);
        return new RedirectView("/post/list");
    }
}



















