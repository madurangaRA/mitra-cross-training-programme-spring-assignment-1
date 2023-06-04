package com.mitra.bank.service.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
public class TransactionHistoryResponse {
    private String id;
    private Date date;
    private String transactionType;
    private double amount;
}