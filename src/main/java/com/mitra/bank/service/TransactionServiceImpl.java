package com.mitra.bank.service;

import com.mitra.bank.domain.Account;
import com.mitra.bank.domain.Transaction;
import com.mitra.bank.repository.AccountRepository;
import com.mitra.bank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account doTransaction(Transaction transaction, String accountType) {

       // AccountValidater.validateCreateAccountRequest(transaction);
        Account existingAccount =  accountRepository.findById(transaction.getAccountNumber()).orElse(null);;
        if(existingAccount != null) {

            Calendar calendar = Calendar.getInstance();
            transaction.setDate(calendar.getTime());

            if(accountType.equals("deposit")){
                transaction.setTransactionType("deposit");
                existingAccount.setBalance(existingAccount.getBalance()+transaction.getAmount());
            }else {
                existingAccount.setBalance(existingAccount.getBalance()-transaction.getAmount());
                transaction.setTransactionType("withdraw");
            }
            transactionRepository.save(transaction);
        }
        return accountRepository.save(existingAccount);
    }

    @Override
    public List<Transaction> getHistory(String accountNumber) {
            return transactionRepository.findAllByAccountNumber(accountNumber);
        }
}
