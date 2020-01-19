package com.spring.git.bankApp.domain.account;

import com.spring.git.bankApp.domain.model.account.Account;

public interface AccountRetrievalClient {


    Account findCardByAccountNumber(String accountNumber);

}
