package com.mitra.bank.service.validation;

public interface Message {
        public static final String INVALID_CUSTOMER_NAME = "Customer name must not be null or empty";
        public static final String INVALID_ACCOUNT_TYPE = "Account type should either CURRENT or SAVINGS";
        public static final String INVALID_BIRTHDAY = "Birthday is invalid";
        public static final String INVALID_NIC = "NIC number is invalid";

    }
