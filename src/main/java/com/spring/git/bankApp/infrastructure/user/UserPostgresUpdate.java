package com.spring.git.bankApp.infrastructure.user;

import com.spring.git.bankApp.domain.model.user.User;
import com.spring.git.bankApp.domain.user.UserCommand;
import com.spring.git.bankApp.domain.user.UserUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserPostgresUpdate implements UserUpdate {

    private final UserRepository userRepository;

    @Override
    public void updatePassword(String login, String oldPassword, String newPassword) {
        User user = userRepository.findByLogin(login);
        user.updatePassword(oldPassword, newPassword);
        userRepository.save(user);
    }

    @Override
    public void updateLogin(String oldLogin, String newLogin, String password) {
        User user = userRepository.findByLogin(oldLogin);
        user.updateLogin(newLogin, password);
        userRepository.save(user);
    }
}
