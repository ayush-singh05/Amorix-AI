package com.amorix.Amorix.AI.Service.impl;

import com.amorix.Amorix.AI.Dto.Member.Request.InviteMemberRequestDto;
import com.amorix.Amorix.AI.Dto.Member.Request.UpdateMemberRoleRequestDto;
import com.amorix.Amorix.AI.Dto.Member.Response.MemberResponseDto;
import com.amorix.Amorix.AI.Entity.Project;
import com.amorix.Amorix.AI.Entity.ProjectMember;
import com.amorix.Amorix.AI.Entity.ProjectMemberId;
import com.amorix.Amorix.AI.Entity.User;
import com.amorix.Amorix.AI.Repository.ProjectMemberRepository;
import com.amorix.Amorix.AI.Repository.ProjectRepository;
import com.amorix.Amorix.AI.Repository.UserRepository;
import com.amorix.Amorix.AI.Security.AuthUtil;
import com.amorix.Amorix.AI.Service.ProjectMemberService;
import com.amorix.Amorix.AI.Transformer.ProjectTransformer;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectRepository projectRepository;
    ProjectMemberRepository projectMemberRepository;
    UserRepository userRepository;
    AuthUtil authUtil;

    @Override
    @PreAuthorize("@security.canViewMembers(#projectId)")
    public List<MemberResponseDto> getProjectMember(Long projectId) {

        return projectMemberRepository.findByIdProjectId(projectId)
                .stream()
                .map(ProjectTransformer::ProjectMemberToMemberResponseDto)
                .toList();

//        Long userId = 1L;
//
//        // Validate access
//        Project project = getAccessibleProjectById(projectId, userId);
//
//        List<MemberResponseDto> memberResponseDtoList = new ArrayList<>();
//
//        // Add project owner
//        MemberResponseDto ownerDto =
//                ProjectTransformer.OwnerToMembarResponseDto(project.getOwner());
//
//        memberResponseDtoList.add(ownerDto);
//
//        // Fetch project members
//        List<ProjectMember> members =
//                projectMemberRepository.findByIdProjectId(projectId);
//
//        // Convert members to DTO
//        List<MemberResponseDto> memberDtos = members.stream()
//                .map(ProjectTransformer::ProjectMemberToMemberResponseDto)
//                .toList();
//
//        memberResponseDtoList.addAll(memberDtos);
//
//        return memberResponseDtoList;
    }

    @Override
    @PreAuthorize("@security.canManageMembers(#projectId)")
    public MemberResponseDto inviteMember(Long projectId, InviteMemberRequestDto request) {
        long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);
        User invitee = userRepository.findByUsername(request.username()).orElseThrow();

        if(invitee.getId().equals(userId)) {
            throw new RuntimeException("Can't Invite yourself");
        }
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, invitee.getId());
        if(projectMemberRepository.existsById(projectMemberId)) {
            throw new RuntimeException("Cannot invite once again");
        }

        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();
        projectMemberRepository.save(projectMember);
        return ProjectTransformer.ProjectMemberToMemberResponseDto(projectMember);
    }

    @Override
    public MemberResponseDto updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequestDto request) {
        long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId)
                .orElseThrow(()-> new RuntimeException("Member not found"));

        projectMember.setProjectRole(request.role());
        ProjectMember saveProject = projectMemberRepository.save(projectMember);
        return ProjectTransformer.ProjectMemberToMemberResponseDto(saveProject);
    }

    @Override
    public void deleteProjectMember(Long projectId, Long memberId) {
        long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        if(!projectMemberRepository.existsById(projectMemberId)) {
            throw new RuntimeException("Member not found in project");
        }
        projectMemberRepository.deleteById(projectMemberId);

    }

    // Internal function
    public Project getAccessibleProjectById(Long projectId, Long userId) {
        return projectRepository.findAllAccessibleProjectById(projectId, userId).orElseThrow();
    }
}
