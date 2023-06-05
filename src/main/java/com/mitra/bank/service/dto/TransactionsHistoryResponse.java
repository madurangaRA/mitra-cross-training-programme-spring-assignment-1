package com.mitra.bank.service.dto;

import jakarta.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Transaction response list requesting a transaction history .
 */
@Getter
@Setter
public class TransactionsHistoryResponse {

    private List<TransactionHistoryResponse> transactions;
}
