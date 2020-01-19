package com.spring.git.bankApp.domain.model.user;


import com.spring.git.bankApp.domain.model.Auditable;
import com.spring.git.bankApp.domain.model.account.Account;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder(access = AccessLevel.PRIVATE)
@Table(name = "users")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<Account> accounts = new HashSet<>();

    public static User createUser(String login, Gender gender) {
        return User.builder().login(login)
                .gender(gender).build();
    }



    public void addAccount(Account account) {
        accounts.add(account);
    }

}
