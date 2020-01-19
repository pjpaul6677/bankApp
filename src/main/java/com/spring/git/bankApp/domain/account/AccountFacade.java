package com.spring.git.bankApp.domain.account;

import com.spring.git.bankApp.domain.model.account.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountFacade {

    private final AccountCreator accountCreator;
    private final AccountRetrievalClient accountRetrievalClient;

    public void createToUser(long userId) {
        accountCreator.createToUser(userId);
    }

    public Account findAccountByAccountNumber(String accountNumber) {
        return accountRetrievalClient.findByAccountNumber(accountNumber);
    }
}
