package com.app.file.service;

import com.app.file.dao.FileDAO;
import com.app.file.domain.FileVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final FileDAO fileDAO;
    @Override
    public void register(FileVO fileVO) {
        fileDAO.save(fileVO);
    }

    @Override
    public List<FileVO> getList() {
        return fileDAO.findAll();
    }
}
