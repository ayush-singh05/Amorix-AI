package com.amorix.Amorix.AI.Entity;

import com.amorix.Amorix.AI.Enum.ProjectRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;
import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table(name = "project_members")
@Entity
public class ProjectMember {

    @EmbeddedId
    ProjectMemberId id;

    @ManyToOne @MapsId("projectId")
    @JoinColumn(name = "project_id")
    Project project;

    @ManyToOne @MapsId("userId")
    @JoinColumn(name = "user_id")
    User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    ProjectRole projectRole;

    Instant invitedAt;
    Instant acceptedAt;
}