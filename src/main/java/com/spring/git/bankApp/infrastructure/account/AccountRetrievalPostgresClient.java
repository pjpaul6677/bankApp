package com.spring.git.bankApp.infrastructure.account;

import com.spring.git.bankApp.domain.account.AccountRetrievalClient;
import com.spring.git.bankApp.domain.model.account.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
class AccountRetrievalPostgresClient implements AccountRetrievalClient {

    private final AccountRepository accountRepository;

    @Override
    public Account findCardByAccountNumber(String accountNumber) {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .filter(s -> s.getAccountNumber().equals(accountNumber))
                .findFirst().get();
    }
}
