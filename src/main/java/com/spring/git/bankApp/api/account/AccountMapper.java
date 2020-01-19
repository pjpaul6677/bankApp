package com.spring.git.bankApp.api.account;


import com.spring.git.bankApp.domain.model.account.Account;

class AccountMapper {

    static AccountDto mapToDto(Account account) {
        return AccountDto.builder()
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance())
                .build();
    }
}
