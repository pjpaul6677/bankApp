package com.spring.git.bankApp.infrastructure.account;

import com.spring.git.bankApp.domain.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
