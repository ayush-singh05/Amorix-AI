package com.amorix.Amorix.AI.Entity;

import com.amorix.Amorix.AI.Enum.PreviewStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Preview {
    BigInteger id;
    BigInteger projectId;
    String nameSpace;
    String podName;
    String previewUrl;
    PreviewStatus previewStatus;
    Instant createdAt;
    Instant updatedAt;
    Instant terminatedAt;
}