package com.amorix.Amorix.AI.Service.impl;

import com.amorix.Amorix.AI.Dto.Member.Request.InviteMemberRequestDto;
import com.amorix.Amorix.AI.Dto.Member.Response.MemberResponseDto;
import com.amorix.Amorix.AI.Entity.ProjectMember;
import com.amorix.Amorix.AI.Service.ProjectMemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {
    @Override
    public List<ProjectMember> getProjectMember(String projectId) {
        return List.of();
    }

    @Override
    public MemberResponseDto inviteMember(Long projectId, InviteMemberRequestDto request, Long userId) {
        return null;
    }

    @Override
    public MemberResponseDto deleteProjectMember(Long projectId, Long memberId, InviteMemberRequestDto request) {
        return null;
    }
}
