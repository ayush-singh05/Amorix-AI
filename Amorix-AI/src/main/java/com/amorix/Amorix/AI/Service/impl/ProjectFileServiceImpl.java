package com.amorix.Amorix.AI.Service.impl;

import com.amorix.Amorix.AI.Dto.Project.Response.FileContentResponseDto;
import com.amorix.Amorix.AI.Dto.Project.Response.FileNodeResponseDto;
import com.amorix.Amorix.AI.Dto.Project.Response.FileTreeResponseDto;
import com.amorix.Amorix.AI.Entity.ProjectFile;
import com.amorix.Amorix.AI.Service.ProjectFileService;

import java.util.List;

public class ProjectFileServiceImpl implements ProjectFileService {
    @Override
    public FileTreeResponseDto getFileTree(Long projectId) {
        List<ProjectFile> projectFileList = projectFileRepository.findByProjectId(projectId);
        List<FileNodeResponseDto> projectFileNodes = projectFileMapper.toListOfFileNode(projectFileList);
        return new FileTreeResponseDto(projectFileNodes);
    }

    @Override
    public FileContentResponseDto getFileContent(Long projectId, String path) {
        return null;
    }

    @Override
    public void saveFile(Long projectId, String filePath, String fileContent) {

    }
}
