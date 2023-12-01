package com.app.restful.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@ApiModel(value = "게시글 정보")
public class PostDTO {
    @ApiModelProperty(value = "게시글 번호", example = "81", required = true)
    private Long id;
    @ApiModelProperty(value = "게시글 제목", example = "테스트 제목1", required = true)
    private String postTitle;
    @ApiModelProperty(value = "게시글 내용", example = "테스트 내용1", required = true)
    private String postContent;
    @ApiModelProperty(value = "조회수", example = "33")
    private Long postReadCount;
    @ApiModelProperty(value = "회원 번호", example = "41", required = true)
    private Long memberId;
    @ApiModelProperty(value = "회원 이름", example = "홍길동")
    private String memberName;
}
