package com.amorix.Amorix.AI.Service.impl;

import com.amorix.Amorix.AI.Dto.File.Response.FileContentResponseDto;
import com.amorix.Amorix.AI.Dto.Project.Response.FileNodeResponseDto;
import com.amorix.Amorix.AI.Service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FileServiceImpl implements FileService {
    @Override
    public List<FileNodeResponseDto> getFileTree(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public FileContentResponseDto getFileContent(Long projectId, String path, Long userId) {
        return null;
    }
}
