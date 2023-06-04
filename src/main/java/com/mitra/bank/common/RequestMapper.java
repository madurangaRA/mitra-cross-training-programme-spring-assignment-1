package com.mitra.bank.common;

public interface RequestMapper {
    String CREATE_ACCOUNT = "/account";
    String CHECK_BALANCE = "/balance/{accountNumber}";
    String WITHDRAW = "/withdraw";
    String DEPOSIT = "/deposit";
    String HISTORY = "/history/{accountNumber}";
}
