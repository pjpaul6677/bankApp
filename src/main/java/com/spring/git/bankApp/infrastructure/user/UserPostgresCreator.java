package com.spring.git.bankApp.infrastructure.user;

import com.spring.git.bankApp.domain.user.UserCommand;
import com.spring.git.bankApp.domain.user.UserCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserPostgresCreator implements UserCreator {

    private final UserRepository userRepository;

    @Override
    public void create(String login) {
        UserCommand userCommand = UserCommand.builder().login(login).build();
        userRepository.save(userCommand.generateUser());
    }
}
