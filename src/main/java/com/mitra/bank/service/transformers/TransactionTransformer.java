package com.mitra.bank.service.transformers;

import com.mitra.bank.domain.Account;
import com.mitra.bank.domain.Transaction;
import com.mitra.bank.service.dto.DoTransactionRequest;
import com.mitra.bank.service.dto.DoTransactionResponse;
import com.mitra.bank.service.dto.TransactionHistoryResponse;
import com.mitra.bank.service.dto.TransactionsHistoryResponse;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class TransactionTransformer {

    private TransactionTransformer(){
        throw new RuntimeException("Identified the Reflection Attack");
    }

    public static Transaction doTransactionRequestToDomain(DoTransactionRequest transactionRequest) {
        Transaction target= new Transaction();
        BeanUtils.copyProperties( transactionRequest, target );
        return target;
    }
    public static DoTransactionResponse doTransactionDomainToRequest(Account account) {
        DoTransactionResponse target = new DoTransactionResponse();
        target.setBalance(account.getBalance());
        return target;
    }

    public static TransactionHistoryResponse TransactionHistoryDomainToResponse(Transaction transaction) {
        TransactionHistoryResponse target = new TransactionHistoryResponse();
        BeanUtils.copyProperties(transaction, target);
        return target;

    }
    public static List<TransactionHistoryResponse> transactionHistoryDomainListToResponseList(List<Transaction> transactionHistoryDomainObjectList){
        List<TransactionHistoryResponse> transactionHistoryResponseList = new ArrayList<TransactionHistoryResponse>();
        for (Transaction transaction : transactionHistoryDomainObjectList) {
            TransactionHistoryResponse responseObject =   TransactionHistoryDomainToResponse(transaction);
            transactionHistoryResponseList.add(responseObject);
        }
        return transactionHistoryResponseList;
    }

}
