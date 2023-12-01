package com.app.restful.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@ApiModel(value = "회원 정보")
public class MemberVO implements Serializable {
    @ApiModelProperty(value = "회원 번호", example = "41", required = true)
    private Long id;
    @ApiModelProperty(value = "회원 이메일", example = "test@app.com", required = true)
    private String memberEmail;
    @ApiModelProperty(value = "회원 비밀번호", example = "비공개", required = true)
    private String memberPassword;
    @ApiModelProperty(value = "회원 이름", example = "홍길동")
    private String memberName;
}
