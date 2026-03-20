package com.amorix.Amorix.AI.Entity;

import com.amorix.Amorix.AI.Enum.ProjectRole;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMemberId implements Serializable {
    Long projectId;
    Long userId;
}