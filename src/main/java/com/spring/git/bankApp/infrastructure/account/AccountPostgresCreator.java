package com.spring.git.bankApp.infrastructure.account;

import com.spring.git.bankApp.domain.account.AccountCreator;
import com.spring.git.bankApp.domain.model.account.AccountCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountPostgresCreator implements AccountCreator {

    private final AccountRepository accountRepository;

    @Override
    public void create(String accountNumber, BigDecimal balance) {
        AccountCommand accountCommand = AccountCommand.builder()
                .accountNumber(accountNumber).balance(balance).build();
        accountRepository.save(accountCommand.createAccount());
    }
}
