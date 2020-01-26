package com.spring.git.bankApp.api.account;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Builder
@Value
public class AccountDto {

    @NotNull
    private String accountNumber;

    @NotNull
    private BigDecimal balance;

}
