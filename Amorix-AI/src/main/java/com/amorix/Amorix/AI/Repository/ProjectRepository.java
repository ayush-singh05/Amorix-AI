package com.amorix.Amorix.AI.Repository;

import com.amorix.Amorix.AI.Entity.Project;
import com.amorix.Amorix.AI.Enum.ProjectRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    @Query("""
            SELECT p FROM Project p
            WHERE p.deletedAt IS NULL
            AND p.owner.id = :userId
            ORDER BY p.updatedAt DESC
            """
    )
    List<Project> findAllAccessibleByUser(@Param("userId") Long userId);

    Project findAllById(Long id);


    @Query("""
        SELECT p FROM Project p
        LEFT JOIN FETCH p.owner
        WHERE p.id = :projectId
        AND p.deletedAt IS NULL
        AND p.owner.id = :userId
        """)
    Optional<Project> findAllAccessibleProjectById(@Param("projectId") Long projectId, @Param("userId") Long userId);

    @Query("""
            SELECT p as project, pm.projectRole as role
            FROM Project p
            JOIN ProjectMember pm ON pm.project.id = p.id
            WHERE p.id = :projectId
              AND pm.user.id = :userId
              AND p.deletedAt IS NULL
            """)
    Optional<ProjectWithRole> findAccessibleProjectByIdWithRole(@Param("projectId") Long projectId, @Param("userId") long userId);

    interface ProjectWithRole {
        Project getProject();
        ProjectRole getRole();
    }
}
