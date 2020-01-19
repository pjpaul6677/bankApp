package com.spring.git.bankApp.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserCreator userCreator;

    public void createUser(UserCommand userCommand) {
        userCreator.createUser(userCommand.getLogin(), userCommand.getGender());
    }
}
