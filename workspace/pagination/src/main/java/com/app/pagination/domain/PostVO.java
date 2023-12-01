package com.app.pagination.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PostVO {
    private Long id;
    private String postTitle;
    private String postContent;
    private Integer postReadCount;
    private String postWriter;
    private String createdDate;
    private String updatedDate;
}
