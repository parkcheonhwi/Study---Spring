package com.app.mybatis.mapper;

import com.app.mybatis.domain.MemberVO;
import com.app.mybatis.domain.PostDTO;
import com.app.mybatis.domain.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
@Slf4j
public class MapperTests {
    @Autowired
    private TimeMapper timeMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private PostMapper postMapper;

    @Test
    public void postSelectAllWithOrder(){
        String order = "popular";
        if(order == null) {order = "";}
        postMapper.selectAllWithOrder(order)
                .stream().map(PostVO::toString)
                .forEach(log::info);
    }

    @Test
    public void postDeleteTest(){
        postMapper.select(1L)
                .map(PostDTO::getId)
                .ifPresent(postMapper::delete);
    }

    @Test
    public void postUpdateTest(){
        // 게시글 조회
        postMapper.select(1L).ifPresent(postDTO -> {
            PostVO postVO = new PostVO();
            postDTO.setPostTitle("수정된 제목1");
            postDTO.setPostContent("수정된 내용1");

            postVO.setId(postDTO.getId());
            postVO.setPostTitle(postDTO.getPostTitle());
            postVO.setPostContent(postDTO.getPostContent());
            postMapper.update(postVO);
        });
    }


    @Test
    public void postSelectTest(){
//        postMapper.select(1L)
//                .map(PostDTO::toString)
//                .ifPresent(log::info);
        Random random = new Random();
        for(int i=0; i<1000; i++){
            Long id = new Long(random.nextInt(50) + 2);
            postMapper.select(id)
                    .map(PostDTO::getId)
                    .ifPresent(postMapper::updateReadCount);
        }
    }

    @Test
    public void postSelectAllTest(){
        postMapper.selectAll().stream().map(PostVO::toString).forEach(log::info);
    }

    @Test
    public void postInsertTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("hds1234@gmail.com");
        memberVO.setMemberPassword("1234");

        memberMapper.select(memberVO).map(MemberVO::getId)
                .ifPresent(memberId -> {
                    for (int i=0; i<50; i++){
                        PostVO postVO = new PostVO();
                        postVO.setPostTitle("테스트 제목" + (i + 1));
                        postVO.setPostContent("테스트 내용" + (i + 1));
                        postVO.setMemberId(memberId);
                        postMapper.insert(postVO);
                    }
                });
    }

    @Test
    public void memberDeleteTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("hds1234@gmail.com");
        memberVO.setMemberPassword("1234");
        memberMapper.select(memberVO).map(MemberVO::getId)
                .ifPresent(memberMapper::delete);
    }

    @Test
    public void memberSelectTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("hds1234@gmail.com");
        memberVO.setMemberPassword("1234");
        memberMapper.select(memberVO).map(MemberVO::toString)
                .ifPresentOrElse(log::info, () -> {log.info("로그인 실패");});
    }

    @Test
    public void memberInsertTest(){
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("hds1234@gmail.com");
        memberVO.setMemberPassword("1234");
        memberVO.setMemberName("한동석");

        memberMapper.insert(memberVO);
    }

    @Test
    public void getTimeTest(){
        log.info("=======================");
        log.info(timeMapper.getTime());
        log.info(timeMapper.getTime2());
        log.info("=======================");
    }
}
