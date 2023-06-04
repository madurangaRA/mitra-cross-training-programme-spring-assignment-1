package com.mitra.bank.service.dto;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DoTransactionRequest {

    private String accountNumber;
    private double amount;
}
