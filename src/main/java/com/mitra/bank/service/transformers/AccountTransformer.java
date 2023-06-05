package com.mitra.bank.service.transformers;

import com.mitra.bank.domain.Account;
import com.mitra.bank.service.dto.AccountResponse;
import com.mitra.bank.service.dto.BalanceResponse;
import com.mitra.bank.service.dto.CreateAccountRequest;
import org.springframework.beans.BeanUtils;

public class AccountTransformer {

    private AccountTransformer() {
        throw new RuntimeException("Identified the Reflection Attack");
    }

    /**
     * Transforms data form account request object to domain object.
     *
     * @param createRequest the create request
     * @return the account
     */
    public static Account createAccountRequestToDomain(CreateAccountRequest createRequest) {
        Account target = new Account();
        BeanUtils.copyProperties(createRequest, target);
        target.setBalance(0);
        return target;
    }

    /**
     * Transforms data form account domain object to request object.
     *
     * @param account the account
     * @return the account response
     */
    public static AccountResponse accountDomainToResponse(Account account) {
        AccountResponse target = new AccountResponse();
        target.setAccountNumber(account.getId());
        return target;
    }

    /**
     * Transforms data form for checking balance from domain object to request object
     *
     * @param account the account
     * @return the balance response
     */
    public static BalanceResponse balanceDomainToResponse(Account account) {
        BalanceResponse target = new BalanceResponse();
        target.setBalance(account.getBalance());
        return target;
    }

}
