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
public class Project {
    BigInteger id;
    String name;
    BigInteger ownerId;
    Boolean isPublic;
    Instant createdAt;
    Instant updatedAt;
    Instant deletedAt;
}