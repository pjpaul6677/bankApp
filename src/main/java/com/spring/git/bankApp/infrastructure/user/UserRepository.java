package com.spring.git.bankApp.infrastructure.user;

import com.spring.git.bankApp.domain.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
}
