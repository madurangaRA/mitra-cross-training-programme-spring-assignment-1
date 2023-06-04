package com.mitra.bank.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TransactionsHistoryResponse {

    private List<TransactionHistoryResponse> transactions;

}
