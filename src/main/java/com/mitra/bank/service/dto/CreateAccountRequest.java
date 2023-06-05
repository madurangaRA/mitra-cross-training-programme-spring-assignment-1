package com.mitra.bank.service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Request of creat account
 */
@Getter
@Setter
public class CreateAccountRequest {

    @NotNull(message = "customer shouldn't be null")
    private String customerName;

    @NotNull(message = "DOB shouldn't be null")
    private Date dateOfBirth;

    @NotNull(message = "Account type shouldn't be null")
    private String accountType;

    @NotNull(message = "NIC shouldn't be null")
    private String nic;
}
