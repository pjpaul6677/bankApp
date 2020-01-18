package com.spring.git.bankApp.api.account;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class AccountDto {

    @NotNull
    private String accountNumber;

    @NotNull
    private BigDecimal balance;
}
