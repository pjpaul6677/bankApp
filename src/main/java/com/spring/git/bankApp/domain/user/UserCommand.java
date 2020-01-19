package com.spring.git.bankApp.domain.user;

import com.spring.git.bankApp.domain.model.user.Gender;
import com.spring.git.bankApp.domain.model.user.User;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserCommand {
    private String login;
    private Gender gender;

    public User createUser() {
        return User.createUser(login, gender);
    }

}
