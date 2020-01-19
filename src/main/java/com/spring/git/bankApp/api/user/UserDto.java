package com.spring.git.bankApp.api.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.git.bankApp.domain.model.user.Gender;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
@Builder
class UserDto {

    @NotNull
    private final String login;

    @NonNull
    private final Gender gender;
}
