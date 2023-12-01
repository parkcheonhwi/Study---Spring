package com.app.controller.dao;

import com.app.controller.domain.StudentVO;
import com.app.controller.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentDAO {
    private final StudentMapper studentMapper;

    public void save(StudentVO studentVO){
        studentMapper.insert(studentVO);
    }

    public List<StudentVO> findAll(){
        return studentMapper.selectAll();
    }
}
