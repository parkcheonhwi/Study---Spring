package com.app.controller.service;

import com.app.controller.dao.StudentDAO;
import com.app.controller.domain.StudentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentDAO studentDAO;

    @Override
    public void register(StudentVO studentVO) {
        studentDAO.save(studentVO);
    }

    @Override
    public List<StudentVO> getStudents() {
        return studentDAO.findAll();
    }
}
