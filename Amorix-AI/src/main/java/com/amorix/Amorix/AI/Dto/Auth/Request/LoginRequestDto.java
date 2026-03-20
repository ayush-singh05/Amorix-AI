package com.amorix.Amorix.AI.Dto.Auth.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LoginRequestDto(
        @Email @NotNull String email,
        @Size(min = 4, max = 16) String password
) {
}
