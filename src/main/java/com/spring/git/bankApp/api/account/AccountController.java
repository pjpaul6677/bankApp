package com.spring.git.bankApp.api.account;

import com.spring.git.bankApp.domain.account.AccountFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("v1/accounts")
public class AccountController {

    private final AccountFacade accountFacade;

    @PostMapping("/users/{userId}")
    public void createAccount(@NotNull @PathVariable Long userId) {
        accountFacade.createToUser(userId);
        log.info("Account creation for userId {}", userId);
    }

}
