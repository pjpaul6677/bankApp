package com.spring.git.bankApp.domain.user;

import com.spring.git.bankApp.domain.model.user.User;

import java.util.List;

public interface UserRetrievalClient {

    User getById(long userId);

    User getByLogin(String login);

    List<User> findAll();
}
