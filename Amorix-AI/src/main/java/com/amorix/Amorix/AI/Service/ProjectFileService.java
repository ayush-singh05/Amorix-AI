package com.amorix.Amorix.AI.Service;

import com.amorix.Amorix.AI.Dto.Project.Response.FileContentResponseDto;
import com.amorix.Amorix.AI.Dto.Project.Response.FileTreeResponseDto;

public interface ProjectFileService {
    FileTreeResponseDto getFileTree(Long projectId);

    FileContentResponseDto getFileContent(Long projectId, String path);

    void saveFile(Long projectId, String filePath, String fileContent);
}
