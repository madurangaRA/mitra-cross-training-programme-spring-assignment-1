package com.mitra.bank.service.validation;

import com.mitra.bank.common.AccountType;
import com.mitra.bank.domain.Account;
import org.springframework.util.Assert;

import java.util.Date;
import java.text.SimpleDateFormat;


public class AccountValidater {

    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final String NEW_NIC_PATTERN= "[0-9]{12}";
    private static final String OLD_NIC_PATTERN= "^\\d{9}[VX]$\n";

    public static void validateCreateAccountRequest(Account createRequest) {
        Assert.hasText(createRequest.getCustomerName(), Message.INVALID_CUSTOMER_NAME);
        Assert.hasText(createRequest.getAccountType(), Message.INVALID_ACCOUNT_TYPE);
        Assert.isTrue(isValidDateOfBirth(createRequest.getDateOfBirth()), Message.INVALID_BIRTHDAY);
        Assert.isTrue(isValidNIC(createRequest.getNic()), Message.INVALID_NIC);
        Assert.isTrue(isValidAccountType(createRequest.getAccountType()), Message.INVALID_NIC);
    }


    private static boolean isValidDateOfBirth(Date date) {
        boolean isValidDateOfBirth = date != null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( DATE_TIME_FORMAT);

        try {
            simpleDateFormat.format(date);
        } catch (Exception e) {
            return false;
        }

        isValidDateOfBirth = date.before(new Date());

        return isValidDateOfBirth;
    }

    private static boolean isValidNIC(String NIC) {

       boolean newNIC = NIC.matches(NEW_NIC_PATTERN) ;
       boolean oldNIC =  NIC.matches(OLD_NIC_PATTERN);


        return newNIC;
    }

    private static boolean isValidAccountType(String accountType) {
        //return accountType.equals(AccountType.CURRENT) || accountType.equals(AccountType.SAVINGS);

        return true;
    }

}
