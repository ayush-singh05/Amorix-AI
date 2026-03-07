package com.amorix.Amorix.AI.Service;

import com.amorix.Amorix.AI.Dto.Project.Request.ProjectRequestDto;
import com.amorix.Amorix.AI.Dto.Project.Request.ProjectSummaryResponseDto;
import com.amorix.Amorix.AI.Dto.Project.Response.ProjectResponseDto;

import java.util.List;

public interface ProjectService {


    List<ProjectSummaryResponseDto> getUserProjects(Long userId);

    ProjectResponseDto getUserProjectById(Long id, Long userId);

    ProjectResponseDto createProject(ProjectRequestDto request, Long userId);

    ProjectResponseDto updateProject(Long id, ProjectRequestDto request, Long userId);

    void softDelete(Long id, Long userId);

}
