package com.spring.git.bankApp.infrastructure.account;

import com.spring.git.bankApp.domain.model.account.Account;
import com.spring.git.bankApp.domain.account.AccountRetrievalClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@RequiredArgsConstructor
@Service
class AccountRetrievalPostgresClient implements AccountRetrievalClient {

    private final EntityManager entityManager;

    @Override
    public Account findCardByAccountNumber(String accountNumber) {
        Query query = entityManager.createNamedQuery("findAccountByAccountNumber");
        query.setParameter(1,accountNumber);
        return (Account) query.getSingleResult();
    }
}
