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
public class ProjectFile {
    BigInteger id;
    BigInteger projectId;
    String part;
    String minio_objectKey;
    BigInteger createdBy;
    BigInteger updatedBy;
    Instant createdAt;
    Instant updatedAt;
}