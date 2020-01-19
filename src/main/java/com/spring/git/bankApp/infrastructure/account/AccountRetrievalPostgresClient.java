package com.spring.git.bankApp.infrastructure.account;

import com.spring.git.bankApp.domain.account.AccountRetrievalClient;
import com.spring.git.bankApp.domain.model.account.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class AccountRetrievalPostgresClient implements AccountRetrievalClient {

    private final AccountRepository accountRepository;

    @Override
    public Account findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }
}
