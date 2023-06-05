package com.mitra.bank.controller;

import com.mitra.bank.common.RequestMapper;
import com.mitra.bank.domain.Account;
import com.mitra.bank.service.AccountService;
import com.mitra.bank.service.dto.AccountResponse;
import com.mitra.bank.service.dto.BalanceResponse;
import com.mitra.bank.service.dto.CreateAccountRequest;
import com.mitra.bank.service.transformers.AccountTransformer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * Create account.
     *
     * @param createAccountRequest the create account request
     * @return the account response
     */
    @RequestMapping(value = RequestMapper.CREATE_ACCOUNT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody AccountResponse create(@Valid @RequestBody CreateAccountRequest createAccountRequest) {
        Account account = AccountTransformer.createAccountRequestToDomain(createAccountRequest);
        Account createdAccount = accountService.createAccount(account);
        return AccountTransformer.accountDomainToResponse(createdAccount);
    }

    /**
     * Check balance  for a given account number.
     *
     * @param accountNumber the account number
     * @return the balance response
     */
    @RequestMapping(value = RequestMapper.CHECK_BALANCE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody BalanceResponse checkBalance(@PathVariable String accountNumber) {
        Account account = accountService.checkBalance(accountNumber);
        return AccountTransformer.balanceDomainToResponse(account);
    }
}
