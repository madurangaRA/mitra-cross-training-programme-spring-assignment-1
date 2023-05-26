package com.mitra.bank.controller;

import com.mitra.bank.common.RequestMapper;
import com.mitra.bank.domain.Account;
import com.mitra.bank.service.AccountService;
import com.mitra.bank.service.dto.AccountResponse;
import com.mitra.bank.service.dto.CreateAccountRequest;
import com.mitra.bank.service.transformers.AccountTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = RequestMapper.CREATE_ACCOUNT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody AccountResponse create(@RequestBody CreateAccountRequest createAccountRequest) {
        Account account = AccountTransformer.createAccountRequestToDomain(createAccountRequest);
        Account createdAccount = accountService.createAccount(account);
        return AccountTransformer.accountDomainToResponse(createdAccount);
    }
}
