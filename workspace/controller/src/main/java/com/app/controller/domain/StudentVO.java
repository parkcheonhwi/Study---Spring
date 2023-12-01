package com.app.controller.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class StudentVO {
    private Long id;
    private Integer kor;
    private Integer math;
    private Integer eng;
    private Integer total;
    private Double average;
}