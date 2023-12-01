package com.app.threetier.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
// Serializable: 직렬화
// 객체를 저장소에 저장할 때 주소가 아닌 전체 필드의 값을 JSON 혹은 XML로 변환하여 저장한다. 이를 직렬화라고 한다.
// 다시 해당 객체를 가져올 때에는 새로운 객체에 저장된 데이터를 주입해주고 이를 역직렬화라고 한다.
public class MemberVO implements Serializable {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
}
