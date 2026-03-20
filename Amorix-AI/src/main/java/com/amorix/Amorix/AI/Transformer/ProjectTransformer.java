package com.amorix.Amorix.AI.Transformer;

import com.amorix.Amorix.AI.Dto.Member.Response.MemberResponseDto;
import com.amorix.Amorix.AI.Dto.Project.Request.ProjectRequestDto;
import com.amorix.Amorix.AI.Dto.Project.Request.ProjectSummaryResponseDto;
import com.amorix.Amorix.AI.Dto.Project.Response.ProjectResponseDto;
import com.amorix.Amorix.AI.Entity.Project;
import com.amorix.Amorix.AI.Entity.ProjectMember;
import com.amorix.Amorix.AI.Entity.User;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public class ProjectTransformer {
    public static ProjectResponseDto projectToProjectResponseDto(Project project) {
        return ProjectResponseDto.builder()
                .id(project.getId())
                .name(project.getName())
                .createdAt(project.getCreatedAt())
                .updatedAt(project.getUpdatedAt())
                .owner(UserTransformer.userToUserResponse(project.getOwner()))
                .build();
    }
    public static Project projectRequestDtoToProject(ProjectRequestDto request) {
        Project project = Project.builder()
                .name(request.name())
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
    public static MemberResponseDto ProjectMemberToMemberResponseDto(ProjectMember projectMember) {
            MemberResponseDto memberResponseDto = MemberResponseDto.builder()
                    .name(projectMember.getUser().getName())

                    .email(projectMember.getUser().getEmail())
                    .role(projectMember.getProjectRole())
                    .userId(projectMember.getUser().getId())
                    .avatarUrl(projectMember.getUser().getAvatar())
                    .invitedAt(projectMember.getInvitedAt())
                    .build();
            return  memberResponseDto;
    }

    public static MemberResponseDto OwnerToMembarResponseDto(User user) {
        return MemberResponseDto.builder()
                .userId(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
