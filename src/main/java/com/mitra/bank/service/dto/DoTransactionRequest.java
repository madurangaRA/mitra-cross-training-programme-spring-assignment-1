package com.mitra.bank.service.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Request for deposit and withdraw
 */
@Getter
@Setter
public class DoTransactionRequest {

    @NotNull(message = "Account Number shouldn't be null")
    private String accountNumber;

    private double amount;
}
