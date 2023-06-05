package com.mitra.bank.service;

import com.mitra.bank.domain.Account;
import com.mitra.bank.exceptions.AccountTypeWrongException;
import com.mitra.bank.exceptions.TransactionsNotFoundException;
import com.mitra.bank.exceptions.WrongNICException;
import com.mitra.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * The type Account service.
 */
@Service
public class AccountServiceImpl implements AccountService {
    private static final String NEW_NIC_PATTERN = "[0-9]{12}";
    private static final String OLD_NIC_PATTERN = "^\\d{9}[VX]$\n";

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {

        if (!isValidAccountType(account.getAccountType())) {
            String description = String.format("The account type given  %s is wrong. Please mention whether a CURRENT or SAVINGS account.", account.getAccountType());
            throw new AccountTypeWrongException("Wrong account type", description,
                    HttpStatus.BAD_REQUEST);
        }

        if (!isValidNIC(account.getNic())) {
            String description = String.format("The NIC  number  %s format is wrong. it should include 12 numbers or 9 numbers with letter v or x at the end.", account.getNic());
            throw new WrongNICException("Wrong NIC number.", description,
                    HttpStatus.BAD_REQUEST);
        }
        return accountRepository.save(account);
    }

    @Override
    public Account checkBalance(String accountNumber) {

        Account account = accountRepository.findById(accountNumber).orElse(null);

        if (account == null) {
            String description = String.format("Account not found  for %s account number", accountNumber);
            throw new TransactionsNotFoundException("Account Not Found", description,
                    HttpStatus.BAD_REQUEST);
        }
        return account;
    }

    private static boolean isValidAccountType(String accountType) {
        return accountType.equals("CURRENT") || accountType.equals("SAVINGS");
    }

    private static boolean isValidNIC(String NIC) {

        boolean newNIC = NIC.matches(NEW_NIC_PATTERN);
        boolean oldNIC = NIC.matches(OLD_NIC_PATTERN);
        return newNIC || oldNIC;
    }
}
