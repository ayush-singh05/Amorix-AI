package com.amorix.Amorix.AI.Transformer;

import com.amorix.Amorix.AI.Dto.Project.Request.ProjectRequestDto;
import com.amorix.Amorix.AI.Dto.Project.Request.ProjectSummaryResponseDto;
import com.amorix.Amorix.AI.Dto.Project.Response.ProjectResponseDto;
import com.amorix.Amorix.AI.Entity.Project;

import java.util.List;
import java.util.Optional;

public class ProjectTransformer {
    public static ProjectResponseDto projectToProjectResponseDto(Project project) {
        return ProjectResponseDto.builder()
                .name(project.getName())
                .id(project.getId())
                .owner(UserTransformer.userToUserResponse(project.getOwner()))
                .createdAt(project.getCreatedAt())
                .updatedAt(project.getUpdatedAt())
                .build();
    }
    public static Project projectRequestDtoToProject(ProjectRequestDto request) {
        Project project = Project.builder()
                .name(request.name())
                .createdAt(request.createdAt())
                .updatedAt(request.updatedAt())
               // .owner()
                .build();

        return project;
    }
    public static List<ProjectSummaryResponseDto>  projectToProjectSummaryResponseDto( List<Project> projects) {
        return projects.stream()
                .map(project -> new ProjectSummaryResponseDto(
                        project.getId(),
                        project.getName(),
                        project.getCreatedAt(),
                        project.getUpdatedAt()
                )).toList();
    }
}
