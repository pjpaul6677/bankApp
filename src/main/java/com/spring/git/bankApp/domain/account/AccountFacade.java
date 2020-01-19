package com.spring.git.bankApp.domain.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountFacade {

    private final AccountCreator accountCreator;

    public void create(long userId) {
        accountCreator.create(userId);
    }
}
