package com.amorix.Amorix.AI.Dto.Auth.Request;

import java.math.BigInteger;

public record UserProfileResponse(
        BigInteger id,
        String email,
        String name,
        String avatarUrl
) {
}
