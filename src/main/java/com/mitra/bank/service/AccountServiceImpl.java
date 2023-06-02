package com.mitra.bank.service;

import com.mitra.bank.domain.Account;
import com.mitra.bank.repository.AccountRepository;
import com.mitra.bank.service.validation.AccountValidater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {

        AccountValidater.validateCreateAccountRequest(account);

        return accountRepository.save(account);
    }
}
