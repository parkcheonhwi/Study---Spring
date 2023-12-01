package com.app.interceptor.controller;

import com.app.interceptor.domain.PostDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/tests/*")
@Slf4j
public class TestController {
    private final HttpSession session;

    @GetMapping("ex01")
    @ResponseBody
    public List<PostDTO> ex01(){
        return (List<PostDTO>)session.getAttribute("alarms");
    }

    @GetMapping("ex02")
    public String ex02(){
        return "ex02";
    }
}
