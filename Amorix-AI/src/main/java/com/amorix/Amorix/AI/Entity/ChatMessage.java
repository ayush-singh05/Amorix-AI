package com.amorix.Amorix.AI.Entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessage {
    Long id;
    BigInteger userId;
    BigInteger projectId;
    String role;
    String content;
    String toolCallId;
    int tokensUsed;
    Instant createdAt;
}