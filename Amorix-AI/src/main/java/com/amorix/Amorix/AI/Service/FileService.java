package com.amorix.Amorix.AI.Service;

import com.amorix.Amorix.AI.Dto.File.Response.FileContentResponseDto;
import com.amorix.Amorix.AI.Dto.Project.Response.FileNodeResponseDto;

import java.util.List;

public interface FileService {
    List<FileNodeResponseDto> getFileTree(Long projectId, Long userId);

    FileContentResponseDto getFileContent(Long projectId, String path, Long userId);
}
