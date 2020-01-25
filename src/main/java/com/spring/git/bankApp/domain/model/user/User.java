package com.spring.git.bankApp.domain.model.user;


import com.spring.git.bankApp.domain.model.Auditable;
import com.spring.git.bankApp.domain.model.account.Account;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder(access = AccessLevel.PRIVATE)
@Table(name = "users")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Slf4j
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    private String login;

    private String password;

    @Getter
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<Account> accounts = new HashSet<>();

    public static User createUser(String login, Gender gender, String password) {
        return User.builder()
                .login(login)
                .gender(gender)
                .password(password).build();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void updatePassword(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword)) {
           this.password = newPassword;
            log.info("Password updated");
        } else {
             log.info("False password");
        }
    }

    public void updateLogin(String newLogin, String password) {
        if (this.password.equals(password)) {
            this.login = newLogin;
            log.info("Login updated");
        } else {
            log.info("False password");
        }
    }


}
