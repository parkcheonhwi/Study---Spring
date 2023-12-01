package com.app.interceptor.mapper;

import com.app.interceptor.domain.PostDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AlarmMapper {
    public List<PostDTO> select(Long id);
}
