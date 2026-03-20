package com.amorix.Amorix.AI.Dto.Auth.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SignupRequestDto(
        @Email @NotNull String email,
       @NotNull String name,
        @Size(min = 4, max = 16) String password
) {
}
