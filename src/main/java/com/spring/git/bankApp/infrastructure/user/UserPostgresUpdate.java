package com.spring.git.bankApp.infrastructure.user;

import com.spring.git.bankApp.domain.model.user.User;
import com.spring.git.bankApp.domain.user.UserCommand;
import com.spring.git.bankApp.domain.user.UserUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
class UserPostgresUpdate implements UserUpdate {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void updatePassword(String login, String oldPassword, String newPassword) {
        User user = userRepository.findByLogin(login);
        user.updatePassword(oldPassword, newPassword);
    }

    @Override
    @Transactional
    public void updateLogin(String oldLogin, String newLogin, String password) {
        User user = userRepository.findByLogin(oldLogin);
        user.updateLogin(newLogin, password);
    }
}
