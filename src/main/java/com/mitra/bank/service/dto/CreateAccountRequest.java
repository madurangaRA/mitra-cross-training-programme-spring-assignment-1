package com.mitra.bank.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateAccountRequest {

    private String customerName;
    private Date dateOfBirth;
    private String accountType;
    private String nic;
}
