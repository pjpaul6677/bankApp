package com.spring.git.bankApp.api.user;

import com.spring.git.bankApp.domain.model.user.Gender;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
@Builder
class UserDto {

    @NotNull
    private final String login;

    @NotNull
    private final Gender gender;

    @NotNull
    private final String password;
}
