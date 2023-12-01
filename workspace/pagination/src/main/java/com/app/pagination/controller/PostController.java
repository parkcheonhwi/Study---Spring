package com.app.pagination.controller;

import com.app.pagination.domain.Pagination;
import com.app.pagination.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostMapper postMapper;

    @GetMapping("/post/list")
    public void getList(Pagination pagination, Model model){
        pagination.setTotal(postMapper.selectTotal());
        pagination.progress();
        model.addAttribute("pagination", pagination);
        model.addAttribute("posts", postMapper.selectAll(pagination));
    }
}
