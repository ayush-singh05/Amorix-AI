package com.amorix.Amorix.AI.Dto.Auth.Request;

public record SignupRequestDto(
        String email,
        String name,
        String password
) {
}
