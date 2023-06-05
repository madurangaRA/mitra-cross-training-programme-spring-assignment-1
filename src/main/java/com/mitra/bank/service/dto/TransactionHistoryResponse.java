package com.mitra.bank.service.dto;

import lombok.*;

import java.util.Date;

/**
 * Single transaction response when requesting a transaction history .
 */
@Getter
@Setter
public class TransactionHistoryResponse {
    private String id;
    private Date date;
    private String transactionType;
    private double amount;
}