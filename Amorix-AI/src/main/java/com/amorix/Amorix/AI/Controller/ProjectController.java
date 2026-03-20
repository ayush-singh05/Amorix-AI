package com.amorix.Amorix.AI.Controller;

import com.amorix.Amorix.AI.Dto.Project.Request.ProjectRequestDto;
import com.amorix.Amorix.AI.Dto.Project.Request.ProjectSummaryResponseDto;
import com.amorix.Amorix.AI.Dto.Project.Response.ProjectResponseDto;
import com.amorix.Amorix.AI.Entity.Project;
import com.amorix.Amorix.AI.Repository.ProjectRepository;
import com.amorix.Amorix.AI.Service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectSummaryResponseDto>> getMyProjects() {
        Long userId = 1L; //TODO: update later with real Spring Security
        return ResponseEntity.ok(projectService.getUserProjects(userId));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDto> getProjectById(@PathVariable Long id) {
        Long userId = 1L;
        return ResponseEntity.ok(projectService.getUserProjectById(id, userId));

    }

    @PostMapping
    public ResponseEntity<ProjectResponseDto> createProject(@RequestBody @Valid ProjectRequestDto request) {
        Long userId = 1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(request, userId));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectResponseDto> updateProject(@PathVariable Long id, @RequestBody @Valid ProjectRequestDto request) {
        Long userId = 1L;
        return ResponseEntity.ok(projectService.updateProject(id, request, userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        Long userId = 1L;
        projectService.softDelete(id, userId);
        return ResponseEntity.noContent().build();
    }

}
