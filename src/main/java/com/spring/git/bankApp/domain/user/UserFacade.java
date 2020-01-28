package com.spring.git.bankApp.domain.user;

import com.spring.git.bankApp.domain.account.AccountCreator;
import com.spring.git.bankApp.domain.model.user.Gender;
import com.spring.git.bankApp.domain.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserCreator userCreator;
    private final UserRetrievalClient userRetrievalClient;
    private final UserUpdate userUpdate;
    private final AccountCreator accountCreator;

    public void createUser(String login, Gender gender, String password) {
        userCreator.create(login, gender, password);
    }

    public void createUserAndPremiumAccount(String login, Gender gender, String password) {
        userCreator.createUserAndPremiumAccount(login, gender, password);
    }

    public void updatePassword(String login, String oldPassword, String newPassword) {
        userUpdate.updatePassword(login, oldPassword, newPassword);
    }

    public void updateLogin(String oldLogin, String newLogin, String password) {
        userUpdate.updateLogin(oldLogin,newLogin, password);
    }


    public User findByLogin(String login) {
        return userRetrievalClient.getByLogin(login);
    }
}
