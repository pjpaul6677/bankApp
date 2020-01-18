package com.spring.git.bankApp.api.account;

import com.spring.git.bankApp.domain.account.AccountFacade;
import com.spring.git.bankApp.domain.model.account.AccountCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("v1/accounts")
public class AccountController {

    private final AccountFacade accountFacade;

    @PostMapping("/create")
    public void createAccount(@RequestBody AccountDto accountDto) {
        AccountCommand accountCommand = AccountCommand.builder().accountNumber(accountDto.getAccountNumber())
                .balance(accountDto.getBalance()).build();
        accountFacade.create(accountCommand);
    }

}
