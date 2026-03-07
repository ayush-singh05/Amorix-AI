package com.amorix.Amorix.AI.Service;

import com.amorix.Amorix.AI.Dto.Member.Request.InviteMemberRequestDto;
import com.amorix.Amorix.AI.Dto.Member.Response.MemberResponseDto;
import com.amorix.Amorix.AI.Entity.ProjectMember;

import java.util.List;

public interface ProjectMemberService {
    List<ProjectMember> getProjectMember(String projectId);


    MemberResponseDto inviteMember(Long projectId, InviteMemberRequestDto request,Long userId);

    MemberResponseDto deleteProjectMember(Long projectId, Long memberId, InviteMemberRequestDto request);

}
