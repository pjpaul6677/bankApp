package com.spring.git.bankApp.infrastructure.user;

import com.spring.git.bankApp.domain.model.user.User;
import com.spring.git.bankApp.domain.user.UserRetrievalClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class UserRetrievalPostgresClient implements UserRetrievalClient {

    private final UserRepository userRepository;

    @Override
    public User getById(long userId) {
        return userRepository.findById(userId).get();
    }
}
