package com.app.controller.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CompanyVO {
    private Long id;
    private String name;
    private String getToWorkDatetime;
    private String leaveWorkDatetime;
}
