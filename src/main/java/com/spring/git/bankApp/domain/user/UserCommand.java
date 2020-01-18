package com.spring.git.bankApp.domain.user;

import com.spring.git.bankApp.domain.model.user.User;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserCommand {
    private String login;

    public User generateUser() {
        return User.builder().login(login).build();
    }
}
