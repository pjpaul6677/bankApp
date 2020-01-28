package com.spring.git.bankApp.domain.account;

import com.spring.git.bankApp.domain.model.account.Account;

public interface AccountRetrievalClient {


    Account findByAccountNumber(String accountNumber);

    Account findByAccountId(long id);

}
