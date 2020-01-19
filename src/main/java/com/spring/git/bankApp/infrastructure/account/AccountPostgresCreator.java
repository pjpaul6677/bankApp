package com.spring.git.bankApp.infrastructure.account;

import com.spring.git.bankApp.domain.account.AccountCreator;
import com.spring.git.bankApp.domain.model.account.Account;
import com.spring.git.bankApp.domain.model.user.User;
import com.spring.git.bankApp.infrastructure.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountPostgresCreator implements AccountCreator {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void create(long userId) {
        User user = userRepository.findById(userId).get();
        user.addAccount(Account.builder()
                    .accountNumber(UUID.randomUUID().toString().substring(1,17))
                    .balance(BigDecimal.ZERO).build());
    }
}
