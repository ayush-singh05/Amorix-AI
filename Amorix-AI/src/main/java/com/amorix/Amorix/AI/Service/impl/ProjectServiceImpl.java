package com.amorix.Amorix.AI.Service.impl;

import com.amorix.Amorix.AI.Dto.Project.Request.ProjectRequestDto;
import com.amorix.Amorix.AI.Dto.Project.Request.ProjectSummaryResponseDto;
import com.amorix.Amorix.AI.Dto.Project.Response.ProjectResponseDto;
import com.amorix.Amorix.AI.Entity.Project;
import com.amorix.Amorix.AI.Entity.User;
import com.amorix.Amorix.AI.Errors.ResourceNotFoundException;
import com.amorix.Amorix.AI.Repository.ProjectRepository;
import com.amorix.Amorix.AI.Repository.UserRepository;
import com.amorix.Amorix.AI.Service.ProjectService;
import com.amorix.Amorix.AI.Transformer.ProjectTransformer;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Transactional
public class ProjectServiceImpl implements ProjectService {

    UserRepository userRepository;
    ProjectRepository projectRepository;


    @Override
    public List<ProjectSummaryResponseDto> getUserProjects(Long userId) {

        var projects = projectRepository.findAllAccessibleByUser(userId);

        return ProjectTransformer.projectToProjectSummaryResponseDto(projects);
    }


    @Override
    public ProjectResponseDto getUserProjectById(Long id, Long userId) {
        Project project = getAccessibleProjectById(id, userId);
        return ProjectTransformer.projectToProjectResponseDto(project);
    }

    @Override
    public ProjectResponseDto createProject(ProjectRequestDto request, Long userId) {
        User user = userRepository.findById(userId).orElse(null);

        Project project = ProjectTransformer.projectRequestDtoToProject(request);

        project.setOwner(user);
        Project saveProject = projectRepository.saveAndFlush(project);

        return ProjectTransformer.projectToProjectResponseDto(saveProject);
    }

    @Override
    public ProjectResponseDto updateProject(Long id, ProjectRequestDto request, Long userId) {

        Project project = getAccessibleProjectById(id, userId);
        project.setName(request.name());
        Project  saveProject = projectRepository.save(project);

        return ProjectTransformer.projectToProjectResponseDto(saveProject);
    }

    @Override
    public void softDelete(Long id, Long userId) {
        Project project = getAccessibleProjectById(id, userId);
        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }

    // Internal Function
    public Project getAccessibleProjectById(Long projectId, Long userId) {
        return projectRepository.findAllAccessibleProjectById(projectId,userId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", projectId.toString()));
    }
}
