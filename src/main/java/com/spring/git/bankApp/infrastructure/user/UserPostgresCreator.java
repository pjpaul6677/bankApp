package com.spring.git.bankApp.infrastructure.user;

import com.spring.git.bankApp.domain.model.account.Account;
import com.spring.git.bankApp.domain.model.account.AccountType;
import com.spring.git.bankApp.domain.model.user.Gender;
import com.spring.git.bankApp.domain.model.user.User;
import com.spring.git.bankApp.domain.user.UserCommand;
import com.spring.git.bankApp.domain.user.UserCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
                .balance(BigDecimal.valueOf(1000l))
                .accountType(AccountType.PREMIUM).build();
        user.addAccount(account);
    }

    @Override
    @Transactional
    public void createUserAndStandardAccount(String login, Gender gender, String password) {
        User user = User.createUser(login, gender, password);
        userRepository.save(user);
        Account account = Account.builder()
                .accountNumber(UUID.randomUUID().toString().substring(1,17))
                .balance(BigDecimal.ZERO)
                .accountType(AccountType.STANDARD).build();
        user.addAccount(account);
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void userExamples() {
        createUserAndPremiumAccount("John", Gender.MALE, passwordEncoder().encode("John"));
        createUserAndStandardAccount("Robert", Gender.MALE, passwordEncoder().encode("Robert"));
        createUserAndPremiumAccount("Natalie", Gender.FEMALE, passwordEncoder().encode("Natalie"));
        createUserAndStandardAccount("Karen", Gender.FEMALE, passwordEncoder().encode("Karen"));

        User adminKaty = User.createAdmin("Katy", Gender.FEMALE, passwordEncoder().encode("Katy"));
        userRepository.save(adminKaty);
        User adminAleksander = User.createAdmin("Aleksander", Gender.MALE, passwordEncoder().encode("Aleksander"));
        userRepository.save(adminAleksander);
    }


}
