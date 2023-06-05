package com.mitra.bank.service;

import com.mitra.bank.domain.Account;
import com.mitra.bank.domain.Transaction;
import com.mitra.bank.exceptions.BalanceInsufficientException;
import com.mitra.bank.exceptions.TransactionsNotFoundException;
import com.mitra.bank.repository.AccountRepository;
import com.mitra.bank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account doTransaction(Transaction transaction, String accountType) {

        Account existingAccount = accountRepository.findById(transaction.getAccountNumber()).orElse(null);

        if (existingAccount != null) {
            Calendar calendar = Calendar.getInstance();
            transaction.setDate(calendar.getTime());

            double balance = existingAccount.getBalance();
            double amount = transaction.getAmount();

            if (accountType.equals("deposit")) {
                transaction.setTransactionType("deposit");
                existingAccount.setBalance(existingAccount.getBalance() + transaction.getAmount());
            } else {

                if (balance < amount) {
                    String description = String.format("You only have %s in your account", balance);
                    throw new BalanceInsufficientException("Insufficient balance", description,
                            HttpStatus.BAD_REQUEST);
                } else {
                    existingAccount.setBalance(balance - amount);
                    transaction.setTransactionType("withdraw");
                }
            }
            transactionRepository.save(transaction);
        } else {
            String description = String.format("No transactions found for %s account number", transaction.getAccountNumber());
            throw new TransactionsNotFoundException("No Transactions Found", description,
                    HttpStatus.BAD_REQUEST);
        }
        return accountRepository.save(existingAccount);
    }
    @Override
    public List<Transaction> getHistory(String accountNumber) {

        List<Transaction> transactions = transactionRepository.findAllByAccountNumber(accountNumber);

        if(transactions.isEmpty()){
            String description = String.format("No transactions found for %s account number", accountNumber);
            throw new TransactionsNotFoundException("No Transactions Found", description,
                    HttpStatus.BAD_REQUEST);
        }
        return transactions;
    }
}
