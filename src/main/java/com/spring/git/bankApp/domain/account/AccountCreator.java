package com.spring.git.bankApp.domain.account;

import com.spring.git.bankApp.domain.model.account.Account;
import com.spring.git.bankApp.domain.model.user.User;
import com.spring.git.bankApp.domain.user.UserRetrievalClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.UUID;

@RequiredArgsConstructor
@Service
class AccountCreator {

    private final UserRetrievalClient userRetrievalClient;

    @Transactional
    public void createToUser(long userId) {
        User user = userRetrievalClient.getById(userId);
        user.addAccount(Account.builder()
                .accountNumber(UUID.randomUUID().toString().substring(1,17))
                .balance(BigDecimal.ZERO).build());
    }
}
