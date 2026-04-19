package com.amorix.Amorix.AI.Repository;

import aj.org.objectweb.asm.commons.Remapper;
import com.amorix.Amorix.AI.Entity.ProjectMember;
import com.amorix.Amorix.AI.Entity.ProjectMemberId;
import com.amorix.Amorix.AI.Enum.ProjectRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {
    List<ProjectMember> findByIdProjectId(Long projectId);

    @Query("""
    SELECT pm.projectRole 
    FROM ProjectMember pm 
    WHERE pm.id.projectId = :projectId 
    AND pm.id.userId = :userId
""")
    Optional<ProjectRole> findRoleByProjectIdAndUserId(@Param("projectId") Long projectId, @Param("userId")Long userId);

    int countProjectOwnedByUser(Long userId);
}
