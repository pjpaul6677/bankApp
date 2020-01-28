package com.spring.git.bankApp.infrastructure.user;

import com.spring.git.bankApp.domain.model.account.Account;
import com.spring.git.bankApp.domain.model.account.AccountType;
import com.spring.git.bankApp.domain.model.user.Gender;
import com.spring.git.bankApp.domain.model.user.User;
import com.spring.git.bankApp.domain.user.UserCommand;
import com.spring.git.bankApp.domain.user.UserCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class UserPostgresCreator implements UserCreator {

    private final UserRepository userRepository;

    @Override
    public void create(String login, Gender gender, String password) {
        UserCommand userCommand = UserCommand.builder()
                .login(login)
                .gender(gender)
                .password(password).build();
        userRepository.save(userCommand.createUser());
    }

    @Override
    @Transactional
    public void createUserAndPremiumAccount(String login, Gender gender, String password) {
        User user = User.createUser(login, gender, password);
        userRepository.save(user);
        Account account = Account.builder()
                .accountNumber(UUID.randomUUID().toString().substring(1,17))
                .balance(BigDecimal.valueOf(100l))
                .accountType(AccountType.PREMIUM).build();
        user.addAccount(account);
    }


}
