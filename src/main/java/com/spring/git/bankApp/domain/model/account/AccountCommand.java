package com.spring.git.bankApp.domain.model.account;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class AccountCommand {

    private String accountNumber;
    private BigDecimal balance;

    public Account createAccount() {
        return Account.builder().accountNumber(accountNumber)
                .balance(balance).build();
    }
}
