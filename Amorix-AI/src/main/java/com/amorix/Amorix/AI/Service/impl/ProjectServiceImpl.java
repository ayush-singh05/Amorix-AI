package com.amorix.Amorix.AI.Service.impl;

import com.amorix.Amorix.AI.Dto.Project.Request.ProjectRequestDto;
import com.amorix.Amorix.AI.Dto.Project.Request.ProjectSummaryResponseDto;
import com.amorix.Amorix.AI.Dto.Project.Response.ProjectResponseDto;
import com.amorix.Amorix.AI.Entity.Project;
import com.amorix.Amorix.AI.Entity.User;
import com.amorix.Amorix.AI.Repository.ProjectRepository;
import com.amorix.Amorix.AI.Repository.UserRepository;
import com.amorix.Amorix.AI.Service.ProjectService;
import com.amorix.Amorix.AI.Transformer.ProjectTransformer;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    UserRepository userRepository;
    ProjectRepository projectRepository;
//    private static final Logger logger = (Logger) LoggerFactory.getLogger(ProjectTransformer.class);

    @Override
    public List<ProjectSummaryResponseDto> getUserProjects(Long userId) {

        List<Project> projects = projectRepository.findAll();
//        logger.info("user id : " + userId);

        return ProjectTransformer.projectToProjectSummaryResponseDto(projects);
    }


    @Override
    public ProjectResponseDto getUserProjectById(Long id, Long userId) {
           return null;
    }

    @Override
    public ProjectResponseDto createProject(ProjectRequestDto request, Long userId) {
        User user = userRepository.findById(userId).orElse(null);

        Project project = ProjectTransformer.projectRequestDtoToProject(request);
        project.setOwner(user);
        Project saveProject = projectRepository.save(project);

        return ProjectTransformer.projectToProjectResponseDto(saveProject);
    }

    @Override
    public ProjectResponseDto updateProject(Long id, ProjectRequestDto request, Long userId) {
        return null;
    }

    @Override
    public void softDelete(Long id, Long userId) {

    }
}
