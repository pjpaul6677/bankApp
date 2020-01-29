package com.spring.git.bankApp.infrastructure.transfer;

import com.spring.git.bankApp.api.transfer.TransferDto;
import com.spring.git.bankApp.domain.account.AccountRetrievalClient;
import com.spring.git.bankApp.domain.model.account.Account;
import com.spring.git.bankApp.domain.model.transfer.Transfer;
import com.spring.git.bankApp.domain.transfer.TransferCommand;
import com.spring.git.bankApp.domain.transfer.TransferCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
class TransferPostgresCreator implements TransferCreator {

    private final AccountRetrievalClient accountRetrievalClient;
    private final TransferRepository transferRepository;

    @Override
    public void create(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
        Transfer transfer = Transfer.create(fromAccountNumber,toAccountNumber,amount);
        accountRetrievalClient.findByAccountNumber(fromAccountNumber)
                .sendMoney(amount);
        accountRetrievalClient.findByAccNumberOrExtAccount(toAccountNumber)
                .receiveMoney(amount);
        transferRepository.save(transfer);

    }


    @Override
    @Transactional
    public void createMultipleTransfersWithNumbers(List<TransferDto> transfers) {
        Transfer transfer;
        for (int i = 0; i<transfers.size();i++) {
            transfer = Transfer.create(transfers.get(i).getFromAccountNumber(),
                    transfers.get(i).getToAccountNumber(),
                    transfers.get(i).getAmount());
            accountRetrievalClient
                    .findByAccountNumber(transfer.getFromAccountNumber())
                    .sendMoney(transfer.getAmount());
            accountRetrievalClient
                    .findByAccNumberOrExtAccount(transfer.getToAccountNumber())
                    .receiveMoney(transfer.getAmount());
            transferRepository.save(transfer);
        }
    }

    @Override
    @Transactional
    public void createTransfersWithIds(List<TransferCommand> transfers) {
        Account fromAccount;
        Account toAccount;
        Transfer transfer;
        for (int i = 0; i<transfers.size();i++) {
            fromAccount = accountRetrievalClient.findByAccountId(transfers.get(i).getCustomerAccountId());
            toAccount = accountRetrievalClient.findByAccountId(transfers.get(i).getSellerAccountId());
            transfer = Transfer.create(fromAccount.getAccountNumber(),
                    toAccount.getAccountNumber(),
                    transfers.get(i).getAmount());
            fromAccount.sendMoney(transfer.getAmount());
            toAccount.receiveMoney(transfer.getAmount());
            transferRepository.save(transfer);
        }
    }
}
