package com.spring.git.bankApp.domain.user;

import com.spring.git.bankApp.domain.model.user.User;

public interface UserRetrievalClient {

    User getById(long userId);

    User getByLogin(String login);
}
