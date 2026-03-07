package com.amorix.Amorix.AI.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectMember {
    BigInteger projectId;
    BigInteger userId;
    String role; // Editor, Viewer
    BigInteger invitedBy;
    Instant invitedAt;
}