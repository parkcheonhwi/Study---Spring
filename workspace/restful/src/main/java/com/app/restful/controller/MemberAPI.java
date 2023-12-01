package com.app.restful.controller;

import com.app.restful.service.MemberService;
import com.app.restful.domain.MemberVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members/api/*")
public class MemberAPI {
    private final MemberService memberService;

//    회원 정보 조회
    @ApiOperation(value = "회원 정보 조회", notes = "로그인 성공 시 회원 정보를 조회할 수 있는 API")
    @ApiImplicitParam(
            name="id",
            value="회원 번호",
            required = true,
            dataType = "long",
            paramType = "path",
            defaultValue = "None"
    )
    @GetMapping("member/{id}")
    public MemberVO getMember(@PathVariable("id") Long id){
        Optional<MemberVO> foundMember = memberService.getMemberInfo(id);
        if(foundMember.isPresent()){
            return foundMember.get();
        }
        return new MemberVO();
    }

//    회원 탈퇴
    @ApiOperation(value = "회원 탈퇴", notes = "회원 탈퇴 및 작성된 게시글을 전체 삭제하는 API")
    @ApiImplicitParam(
            name="id",
            value="회원 번호",
            required = true,
            dataType = "long",
            paramType = "path",
            defaultValue = "None"
    )
    @DeleteMapping("member/{id}")
    public void withdraw(@PathVariable Long id){
        memberService.withdraw(id);
    }
}






















