package com.spring.git.bankApp.api.user;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    @NotNull
    private String login;
}
