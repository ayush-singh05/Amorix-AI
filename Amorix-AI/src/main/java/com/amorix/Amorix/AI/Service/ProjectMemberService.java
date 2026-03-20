package com.amorix.Amorix.AI.Service;

import com.amorix.Amorix.AI.Dto.Member.Request.InviteMemberRequestDto;
import com.amorix.Amorix.AI.Dto.Member.Request.UpdateMemberRoleRequestDto;
import com.amorix.Amorix.AI.Dto.Member.Response.MemberResponseDto;
import com.amorix.Amorix.AI.Entity.ProjectMember;

import java.util.List;

public interface ProjectMemberService {

    List<MemberResponseDto> getProjectMember(Long projectId);


    MemberResponseDto inviteMember(Long projectId, InviteMemberRequestDto request,Long userId);

    MemberResponseDto updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequestDto request);

    void deleteProjectMember(Long projectId, Long memberId);
}
