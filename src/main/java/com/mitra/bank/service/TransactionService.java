package com.mitra.bank.service;

import com.mitra.bank.domain.Account;
import com.mitra.bank.domain.Transaction;
import com.mitra.bank.exceptions.AccountNotFoundException;

import java.util.List;

public interface TransactionService {
    Account doTransaction(Transaction transaction, String accountType);
    List<Transaction> getHistory(String accountNumber);
}
