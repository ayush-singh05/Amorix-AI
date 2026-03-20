package com.amorix.Amorix.AI.Repository;

import com.amorix.Amorix.AI.Entity.ProjectMember;
import com.amorix.Amorix.AI.Entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {
    List<ProjectMember> findByIdProjectId(Long projectId);
}
