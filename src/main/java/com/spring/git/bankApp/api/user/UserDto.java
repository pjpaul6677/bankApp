package com.spring.git.bankApp.api.user;

import com.spring.git.bankApp.domain.model.user.Gender;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Value
@Builder
class UserDto {

    @Size(min = 3,max = 15)
    @NotNull
    private final String login;

    @NotNull
    private final Gender gender;

    @Size(min = 6,max = 15)
    @NotNull
    private final String password;
}
