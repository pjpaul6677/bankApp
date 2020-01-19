package com.spring.git.bankApp.api.account;

import com.spring.git.bankApp.domain.account.AccountFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("v1/accounts")
public class AccountController {

    private final AccountFacade accountFacade;

    @PostMapping("/users/{userId}")
    public void createAccount(@PathVariable Long userId) {
        accountFacade.createToUser(userId);
        log.info("Account creation for userId {}", userId);
    }

    @GetMapping(path = "/{accountNumber}")
    public ResponseEntity<AccountDto> findCardByAccountNumber(@PathVariable String accountNumber) {
        return ResponseEntity.ok(AccountMapper.mapToDto(accountFacade.findAccountByAccountNumber(accountNumber)));
    }

}
