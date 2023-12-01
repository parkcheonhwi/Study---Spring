package com.app.restful.controller;

import com.app.restful.domain.PostDTO;
import com.app.restful.domain.PostVO;
import com.app.restful.service.PostService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts/api/*")
public class PostAPI {
    private final PostService postService;
    
//    게시글 추가
    @ApiOperation(value = "게시글 작성", notes = "게시글을 새롭게 작성할 수 있는 API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberId", value = "작성자 번호", required = true, dataType = "long", paramType = "body"),
            @ApiImplicitParam(name = "postTitle", value = "게시글 제목", required = true, dataType = "string", paramType = "body"),
            @ApiImplicitParam(name = "postContent", value = "게시글 내용", required = true, dataType = "string", paramType = "body"),
    })
    @PostMapping("write")
    public PostDTO write(@RequestBody PostVO postVO){
        postService.write(postVO);
        Optional<PostDTO> foundPost = postService.getPost(postVO.getId());
        if(foundPost.isPresent()){
            return foundPost.get();
        }
        return new PostDTO();
    }

//    게시글 조회 GetMapping
@ApiOperation(value = "게시글 정보 조회", notes = "게시글 정보를 조회할 수 있는 API")
@ApiImplicitParam(
        name="id",
        value="게시글 번호",
        required = true,
        dataType = "long",
        paramType = "path",
        defaultValue = "None"
)
    @GetMapping("post/{id}")
    public PostDTO getPost(@PathVariable Long id){
        Optional<PostDTO> foundPost = postService.getPost(id);
        if(foundPost.isPresent()){
            return foundPost.get();
        }
        return new PostDTO();
    }

//    게시글 전체 조회 GetMapping
@ApiOperation(value = "게시글 전체 정보 조회", notes = "게시글 전체 정보를 조회할 수 있는 API")
    @GetMapping("posts")
    public List<PostDTO> getList(){
        return postService.getList();
    }
//    게시글 수정 PutMapping
    @ApiOperation(value = "게시글 수정", notes = "게시글 정보를 수정할 수 있는 API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "작성자 번호", required = true, dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "postTitle", value = "게시글 제목", required = true, dataType = "string", paramType = "body"),
            @ApiImplicitParam(name = "postContent", value = "게시글 내용", required = true, dataType = "string", paramType = "body"),
    })
    @PutMapping("posts/{id}")
    public PostDTO modify(@PathVariable Long id, @RequestBody PostVO postVO){
        postVO.setId(id);
        postService.modify(postVO);
        Optional<PostDTO> foundPost = postService.getPost(id);
        if(foundPost.isPresent()){
            return foundPost.get();
        }
        return new PostDTO();
    }

//    게시글 삭제 DeleteMapping
    @ApiOperation(value = "게시글 삭제", notes = "게시글을 삭제할 수 있는 API")
    @ApiImplicitParam(
            name="id",
            value="게시글 번호",
            required = true,
            dataType = "long",
            paramType = "path",
            defaultValue = "None"
    )
    @DeleteMapping("posts/{id}")
    public void remove(@PathVariable Long id){
        postService.remove(id);
    }
}





















