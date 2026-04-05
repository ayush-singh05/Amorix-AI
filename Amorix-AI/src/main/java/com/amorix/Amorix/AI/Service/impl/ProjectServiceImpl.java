package com.amorix.Amorix.AI.Service.impl;

import com.amorix.Amorix.AI.Dto.Project.Request.ProjectRequestDto;
import com.amorix.Amorix.AI.Dto.Project.Response.ProjectResponseDto;
import com.amorix.Amorix.AI.Dto.Project.Response.ProjectSummaryResponseDto;
import com.amorix.Amorix.AI.Entity.Project;
import com.amorix.Amorix.AI.Entity.ProjectMember;
import com.amorix.Amorix.AI.Entity.ProjectMemberId;
import com.amorix.Amorix.AI.Entity.User;
import com.amorix.Amorix.AI.Enum.ProjectRole;
import com.amorix.Amorix.AI.Errors.BadRequestException;
import com.amorix.Amorix.AI.Errors.ResourceNotFoundException;
import com.amorix.Amorix.AI.Repository.ProjectMemberRepository;
import com.amorix.Amorix.AI.Repository.ProjectRepository;
import com.amorix.Amorix.AI.Repository.UserRepository;
import com.amorix.Amorix.AI.Security.AuthUtil;
import com.amorix.Amorix.AI.Service.ProjectService;
import com.amorix.Amorix.AI.Transformer.ProjectTransformer;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProjectServiceImpl implements ProjectService {

    UserRepository userRepository;
    ProjectRepository projectRepository;
    ProjectMemberRepository projectMemberRepository;
    AuthUtil authUtil;


    @Override
    public List<ProjectSummaryResponseDto> getUserProjects() {
        long userId = authUtil.getCurrentUserId();
        var projects = projectRepository.findAllAccessibleByUser(userId);

        return ProjectTransformer.projectToProjectSummaryResponseDto(projects);
    }


    @Override
    @PreAuthorize("@security.canViewProject(#projectId)")
    public ProjectSummaryResponseDto getUserProjectById(Long projectId) {
        long userId = authUtil.getCurrentUserId();
        log.info("getting user id in project {}", userId);
        var projectWithRole = projectRepository.findAccessibleProjectByIdWithRole(projectId,userId)
                .orElseThrow(() -> new BadRequestException("Project with id " + projectId + " not found"));

        return ProjectTransformer.projectToProjectSummaryResponseDto(projectWithRole.getProject(),projectWithRole.getRole());
    }

    @Override
    public ProjectResponseDto createProject(ProjectRequestDto request) {
        log.info("Auth in controller: {}", SecurityContextHolder.getContext().getAuthentication());
        Long userId = authUtil.getCurrentUserId();
        User user = userRepository.getReferenceById(userId);
        Project project = Project.builder()
                .name(request.name())
                .isPublic(false)
                .owner(user)
                .build();

        project = projectRepository.saveAndFlush(project);

        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(), user.getId());

        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)
                .user(user)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();

        projectMemberRepository.save(projectMember);

        log.info("create project time stamp {}", project.getCreatedAt());

        return ProjectTransformer.projectToProjectResponseDto(project);
    }

    @Override
    @PreAuthorize("@security.canEditProject(#projectId)")
    public ProjectResponseDto updateProject(Long projectId, ProjectRequestDto request){
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId);
        project.setName(request.name());
        Project  saveProject = projectRepository.save(project);

        return ProjectTransformer.projectToProjectResponseDto(saveProject);
    }

    @Override
    @PreAuthorize("@security.canDeleteProject(#projectId)")
    public void softDelete(Long id) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(id);
        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }

    // Internal Function
    public Project getAccessibleProjectById(Long projectId) {
        Long userId = authUtil.getCurrentUserId();
        return projectRepository.findAllAccessibleProjectById(projectId,userId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", projectId.toString()));
    }
}
