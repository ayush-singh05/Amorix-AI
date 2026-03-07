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
public class User {
    BigInteger id;
    String name;
    String email;
    String password;
    String avatar;
    Instant createdAt;
    Instant updatedAt;
    Instant deletedAt;
}