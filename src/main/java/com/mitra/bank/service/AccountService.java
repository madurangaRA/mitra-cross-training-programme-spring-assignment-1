package com.mitra.bank.service;

import com.mitra.bank.domain.Account;

import java.util.Optional;

public interface AccountService {
    Account createAccount(Account account);
    Account checkBalance(String accountNumber);
}
