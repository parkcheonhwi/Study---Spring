package com.app.controller.mapper;

import com.app.controller.domain.StudentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
//    학생 정보 추가
    public void insert(StudentVO studentVO);

//    학생 정보 전체 조회
    public List<StudentVO> selectAll();
}
