package com.spring.git.bankApp.infrastructure.transfer;

import com.spring.git.bankApp.api.transfer.TransferDto;
import com.spring.git.bankApp.domain.model.account.Account;
import com.spring.git.bankApp.domain.model.transfer.Transfer;
import com.spring.git.bankApp.domain.transfer.TransferCommand;
import com.spring.git.bankApp.domain.transfer.TransferCreator;
import com.spring.git.bankApp.exceptionHandler.ExceptionHandler;
import com.spring.git.bankApp.infrastructure.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
class TransferPostgresCreator implements TransferCreator {

    private final AccountRepository accountRepository;
    private final TransferRepository transferRepository;

    @Override
    public void create(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
        Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber);
        Account toAccount = accountRepository.findByAccountNumber(toAccountNumber);
        Transfer transfer = Transfer.builder()
                .fromAccountNumber(fromAccountNumber)
                .toAccountNumber(toAccountNumber)
                .amount(amount).build();
        if (fromAccount.sendMoney(amount)) {
            toAccount.receiveMoney(amount);
            transferRepository.save(transfer);
        } else {
            throw new ExceptionHandler();
        }
    }


    @Override
    @Transactional
    public void createMultipleTransfersWithNumbers(List<TransferDto> transfers) {
        List<Transfer> newTransferList = new ArrayList<>();
        Account fromAccount;
        Account toAccount;
        Transfer transfer;
        for (int i = 0; i<transfers.size();i++) {
            transfer = Transfer.builder()
                    .fromAccountNumber(transfers.get(i).getFromAccountNumber())
                    .toAccountNumber(transfers.get(i).getToAccountNumber())
                    .amount(transfers.get(i).getAmount()).build();
            fromAccount = accountRepository.findByAccountNumber(transfer.getFromAccountNumber());
            toAccount = accountRepository.findByAccountNumber(transfer.getToAccountNumber());
            if (fromAccount.sendMoney(transfer.getAmount())) {
                toAccount.receiveMoney(transfer.getAmount());
                transferRepository.save(transfer);
            } else {
                throw new ExceptionHandler();
            }
            newTransferList.add(transfer);
        }
    }

    @Override
    @Transactional
    public void createTransfersWithIds(List<TransferCommand> transfers) {
        List<Transfer> newTransferList = new ArrayList<>();
        Account fromAccount;
        Account toAccount;
        Transfer transfer;
        for (int i = 0; i<transfers.size();i++) {
            fromAccount = accountRepository.findById(transfers.get(i).getCustomerAccountId()).get();
            toAccount = accountRepository.findById(transfers.get(i).getSellerAccountId()).get();
            transfer = Transfer.builder()
                    .fromAccountNumber(fromAccount.getAccountNumber())
                    .toAccountNumber(toAccount.getAccountNumber())
                    .amount(transfers.get(i).getAmount()).build();
            if (fromAccount.sendMoney(transfer.getAmount())) {
                toAccount.receiveMoney(transfer.getAmount());
                transferRepository.save(transfer);
            } else {
                throw new ExceptionHandler();
            }
            newTransferList.add(transfer);
        }
    }
}
