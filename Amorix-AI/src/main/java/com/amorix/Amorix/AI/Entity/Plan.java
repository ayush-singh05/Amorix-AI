package com.amorix.Amorix.AI.Entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Plan {
    Long id;
    String name;
    String stripePriceId;
    int maxProjects;
    int maxTokenPerDay;
    int maxPreview;
    Boolean unlimitedAi;
    Boolean isActive;
    // Features
}
