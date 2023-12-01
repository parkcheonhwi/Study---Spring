package com.app.controller.service;

import com.app.controller.domain.StudentVO;

import java.util.List;

public interface StudentService {
//    학생 정보 추가
    public void register(StudentVO studentVO);

//    학생 정보 전체 조회
    public List<StudentVO> getStudents();
}
