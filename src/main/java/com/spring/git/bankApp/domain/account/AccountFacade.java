package com.spring.git.bankApp.domain.account;

import com.spring.git.bankApp.domain.model.account.AccountCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountFacade {

    private final AccountCreator accountCreator;

    public void create(AccountCommand accountCommand) {
        accountCreator.create(accountCommand.getAccountNumber(), accountCommand.getBalance());
    }
}
