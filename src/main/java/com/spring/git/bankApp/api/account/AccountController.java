package com.spring.git.bankApp.api.account;

import com.spring.git.bankApp.domain.account.AccountFacade;
import com.spring.git.bankApp.domain.model.account.Account;
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

    @PostMapping("/premium/users/{userId}")
    public void createPremiumAccount(@PathVariable Long userId) {
        log.info("Account creation for userId {}", userId);
        accountFacade.createPremiumToUser(userId);
    }

    @PostMapping("/standard/users/{userId}")
    public void createStandardAccount(@PathVariable Long userId) {
        log.info("Account creation for userId {}", userId);
        accountFacade.createStandardToUser(userId);
    }

    @GetMapping(path = "/{accountNumber}")
    public ResponseEntity<AccountDto> findCardByAccountNumber(@PathVariable String accountNumber) {
        AccountDto accountDto = AccountMapper.mapToDto(accountFacade.findAccountByAccountNumber(accountNumber));
        return ResponseEntity.ok(accountDto);
    }

    private static class AccountMapper {
        static AccountDto mapToDto(Account account) {
            return AccountDto.builder()
                    .accountNumber(account.getAccountNumber())
                    .balance(account.getBalance())
                    .build();
        }
    }

}
