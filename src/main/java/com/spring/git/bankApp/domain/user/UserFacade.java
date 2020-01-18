package com.spring.git.bankApp.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserCreator userCreator;

    public void create(UserCommand userCommand) {
        userCreator.create(userCommand.getLogin());
    }
}
