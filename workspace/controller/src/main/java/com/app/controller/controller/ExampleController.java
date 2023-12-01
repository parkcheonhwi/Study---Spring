package com.app.controller.controller;


import com.app.controller.domain.GoodsVO;
import com.app.controller.domain.UserVO;
import com.app.controller.domain.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ex/*")
@Slf4j
public class ExampleController {

    @GetMapping("ex01")
    public void ex01(){
        log.info("ex01 ...............");
    }

    @GetMapping("ex02")
    public void ex02(@ModelAttribute("name") String name){
        log.info("ex02 ...............");
        log.info(name);
    }

//    나이 전달받기
    @GetMapping("ex03")
    public void ex03(@ModelAttribute("age") int age){
        log.info("ex03 ...............");
        log.info("{}살", age);
    }

    @GetMapping("ex04")
    public void ex04(String name, int age, Model model){
        log.info("ex04 ...............");
        log.info("{}: {}살", name, age);
        model.addAttribute("name", name);
        model.addAttribute("age", age);
    }

    @GetMapping("ex05")
    public String ex05(@RequestParam("job") String data, Model model){
        log.info("ex05 ...............");
        log.info("직업: {}", data);
        model.addAttribute("job", data);
        return "ex05";
    }

    @GetMapping("ex06")
    public void ex06(UserVO userVO){
        log.info("ex06 ...............");
        log.info(userVO.toString());
    }

//    상품명, 가격
    @GetMapping("ex07")
    public void ex07(GoodsVO goodsVO){}

}
