package com.mitra.bank.service.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoTransactionRequest {

    @NotNull(message = "Account Number shouldn't be null")
    private String accountNumber;

    @NotNull(message = "Amount shouldn't be null")
    private double amount;
}
