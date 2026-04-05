package com.amorix.Amorix.AI.Service;

import com.amorix.Amorix.AI.Dto.Project.Request.ProjectRequestDto;
import com.amorix.Amorix.AI.Dto.Project.Response.ProjectResponseDto;
import com.amorix.Amorix.AI.Dto.Project.Response.ProjectSummaryResponseDto;

import java.util.List;


public interface ProjectService {


    List<ProjectSummaryResponseDto> getUserProjects();

    ProjectSummaryResponseDto getUserProjectById(Long id);

    ProjectResponseDto createProject(ProjectRequestDto request);

    ProjectResponseDto updateProject(Long id, ProjectRequestDto request);

    void softDelete(Long id);

}
