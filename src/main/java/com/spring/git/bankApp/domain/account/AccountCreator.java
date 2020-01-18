package com.spring.git.bankApp.domain.account;

import java.math.BigDecimal;

public interface AccountCreator {
    void create(String accountNumber, BigDecimal balance);
}
