package com.spring.git.bankApp.domain.user;

public interface UserUpdate {

    void updatePassword(String login, String oldPassword, String newPassword);

    void updateLogin(String oldLogin, String newLogin, String password);

}
