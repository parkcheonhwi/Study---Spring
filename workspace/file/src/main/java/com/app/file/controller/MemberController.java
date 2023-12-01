package com.app.file.controller;

import com.app.file.domain.FileVO;
import com.app.file.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/member/*")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final FileService fileService;

    @GetMapping("detail")
    public void goToDetail(Model model){
        model.addAttribute("files", fileService.getList());
    }

    @GetMapping("mypage")
    public void goToMyPage(){;}

    @PostMapping("mypage")
    public RedirectView updateProfile(@RequestParam("uuid") List<String> uuids, @RequestParam("uploadFile") List<MultipartFile> uploadFiles){
        int count = 0;
        for(int i=0; i<uploadFiles.size(); i++){
            if(uploadFiles.get(i).isEmpty()) {count++; continue;}
            FileVO fileVO = new FileVO();
            fileVO.setFileName(uuids.get(i - count) + "_" + uploadFiles.get(i).getOriginalFilename());
            fileVO.setFilePath(getPath());
            fileService.register(fileVO);
        }
        return new RedirectView("/member/detail");
    }

    private String getPath() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
}













