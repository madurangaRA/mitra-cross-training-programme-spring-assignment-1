package com.mitra.bank.service.transformers;

import com.mitra.bank.domain.Account;
import com.mitra.bank.service.dto.AccountResponse;
import com.mitra.bank.service.dto.BalanceResponse;
import com.mitra.bank.service.dto.CreateAccountRequest;
import org.springframework.beans.BeanUtils;

public class AccountTransformer {

    private AccountTransformer(){
        throw new RuntimeException("Identified the Reflection Attack");
    }

    public static Account createAccountRequestToDomain(CreateAccountRequest createRequest) {
        Account target= new Account();
        BeanUtils.copyProperties( createRequest, target );
        target.setBalance(0);
        return target;
    }

    public static AccountResponse accountDomainToResponse(Account account) {
        AccountResponse target = new AccountResponse();
        target.setAccountNumber(account.getId());
        return target;
    }
    public static BalanceResponse balanceDomainToResponse(Account account) {
        BalanceResponse target = new BalanceResponse();
        target.setBalance(account.getBalance());
        return target;
    }

}
