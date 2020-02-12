package com.spring.git.bankApp.domain.model.user;


import com.spring.git.bankApp.domain.model.Auditable;
import com.spring.git.bankApp.domain.model.account.Account;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder(access = AccessLevel.PRIVATE)
@Table(name = "users")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Slf4j
@Getter
public class User extends Auditable implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_sequence")
    private Long id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Account> accounts;

    public static User createUser(String username, Gender gender, String password) {
        return User.builder()
                .username(username)
                .gender(gender)
                .role(Role.ROLE_USER)
                .password(password)
                .accounts(new HashSet<>()).build();
    }

    public static User createAdmin(String username, Gender gender, String password) {
        return User.builder()
                .username(username)
                .gender(gender)
                .role(Role.ROLE_ADMIN)
                .password(password)
                .accounts(new HashSet<>()).build();
    }

    public void addAccount(Account account) {
        account.setUser(this);
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

    public void updateUsername(String newLogin, String password) {
        if (this.password.equals(password)) {
            this.username = newLogin;
            log.info("Login updated");
        } else {
            log.info("False password");
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role.toString()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
