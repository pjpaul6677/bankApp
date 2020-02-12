package com.spring.git.bankApp.domain.model.account;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    @ParameterizedTest
    @ValueSource(longs = {11l, 20l, 30l, 40l, 50l})
    void insufficientBalanceTest(long amount) {
        Account account = Account.builder().balance(BigDecimal.TEN).build();
        assertThrows(HttpClientErrorException.class, () -> account.sendMoney(BigDecimal.valueOf(amount)));
    }

    @ParameterizedTest
    @ValueSource(longs = {1l, 2l, 3l, 4l, 5l})
    void sufficientBalanceTest(long amount) {
        Account account = Account.builder().balance(BigDecimal.TEN).build();
        account.sendMoney(BigDecimal.valueOf(amount));
        assertEquals(account.getBalance(),
                BigDecimal.TEN.subtract(BigDecimal.valueOf(amount)));
    }

    @ParameterizedTest
    @ValueSource(longs = {11l, 20l, 30l, 40l, 50l})
    void receiveMoneyTest(long amount) {
        Account account = Account.builder().balance(BigDecimal.ZERO).build();
        account.receiveMoney(BigDecimal.valueOf(amount));
        assertEquals(account.getBalance(),
                BigDecimal.ZERO.add(BigDecimal.valueOf(amount)));
    }

}

