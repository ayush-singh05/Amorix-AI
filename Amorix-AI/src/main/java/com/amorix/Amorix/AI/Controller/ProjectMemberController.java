package com.amorix.Amorix.AI.Controller;

import com.amorix.Amorix.AI.Dto.Member.Request.InviteMemberRequestDto;
import com.amorix.Amorix.AI.Dto.Member.Request.UpdateMemberRoleRequestDto;
import com.amorix.Amorix.AI.Dto.Member.Response.MemberResponseDto;
import com.amorix.Amorix.AI.Entity.ProjectMember;
import com.amorix.Amorix.AI.Service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/{projectId}/members")
@RequiredArgsConstructor
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;

    @GetMapping
    public ResponseEntity<List<MemberResponseDto>> getProjectMembers(@PathVariable Long projectId) {
        Long userId = 10L;
        return ResponseEntity.ok(projectMemberService.getProjectMember(projectId));
    }

    @PostMapping
    public ResponseEntity<MemberResponseDto>inviteMember(
            @PathVariable Long projectId,
            @RequestBody InviteMemberRequestDto request
    ){
        Long userId = 1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(projectMemberService.inviteMember(projectId,request,userId));
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponseDto> updateMemberRole(
            @PathVariable Long projectId,
            @PathVariable Long memberId,
            @RequestBody UpdateMemberRoleRequestDto request
    ){
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.updateMemberRole(projectId,memberId,request));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long projectId, @PathVariable Long memberId){
        projectMemberService.deleteProjectMember(projectId,memberId);
        return ResponseEntity.noContent().build();
    }
}
