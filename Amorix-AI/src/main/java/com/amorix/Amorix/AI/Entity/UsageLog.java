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
public class UsageLog {
    BigInteger id;
    BigInteger userId;
    BigInteger projectId;
    String action;
    int tokenUses;
    int durationMs;
    Instant createdAt;
}