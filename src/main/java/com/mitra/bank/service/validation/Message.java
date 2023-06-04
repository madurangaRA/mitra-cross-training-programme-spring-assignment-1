package com.mitra.bank.service.validation;

public interface Message {
    String INVALID_CUSTOMER_NAME = "Customer name must not be null or empty";
    String INVALID_ACCOUNT_TYPE = "Account type should either CURRENT or SAVINGS";
    String INVALID_BIRTHDAY = "Birthday is invalid";
    String INVALID_NIC = "NIC number is invalid";

    }
