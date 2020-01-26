package com.spring.git.bankApp.api.account;

import com.spring.git.bankApp.domain.account.AccountFacade;
import com.spring.git.bankApp.domain.model.account.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("v1/accounts")
@Validated
public class AccountController {

    private final AccountFacade accountFacade;

    @PostMapping("/premium/users/{userId}")
    public void createPremiumAccount(@PathVariable @Min(1) Long userId) {
        log.info("Account creation for userId {}", userId);
        accountFacade.createPremiumToUser(userId);
    }

    @PostMapping("/standard/users/{userId}")
    public void createStandardAccount(@PathVariable @Min(1) Long userId) {
        log.info("Account creation for userId {}", userId);
        accountFacade.createStandardToUser(userId);
    }

    @GetMapping(path = "/{accountNumber}")
    public ResponseEntity<AccountDto> findCardByAccountNumber(@Size(min = 16, max = 16) @PathVariable String accountNumber) {
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
