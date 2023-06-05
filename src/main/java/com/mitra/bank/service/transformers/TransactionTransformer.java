package com.mitra.bank.service.transformers;

import com.mitra.bank.domain.Account;
import com.mitra.bank.domain.Transaction;
import com.mitra.bank.service.dto.DoTransactionRequest;
import com.mitra.bank.service.dto.DoTransactionResponse;
import com.mitra.bank.service.dto.TransactionHistoryResponse;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class TransactionTransformer {

    private TransactionTransformer() {
        throw new RuntimeException("Identified the Reflection Attack");
    }

    /**
     * Transforms data form transaction request object to domain object.
     *
     * @param transactionRequest the transaction request
     * @return the transaction
     */
    public static Transaction doTransactionRequestToDomain(DoTransactionRequest transactionRequest) {
        Transaction target = new Transaction();
        BeanUtils.copyProperties(transactionRequest, target);
        return target;
    }

    /**
     * Transforms data form transaction domain object to  request object.
     *
     * @param account the account
     * @return the do transaction response
     */
    public static DoTransactionResponse doTransactionDomainToRequest(Account account) {
        DoTransactionResponse target = new DoTransactionResponse();
        target.setBalance(account.getBalance());
        return target;
    }

    /**
     * Transforms data form transaction history domain object to  response object.
     *
     * @param transaction the transaction
     * @return the transaction history response
     */
    public static TransactionHistoryResponse TransactionHistoryDomainToResponse(Transaction transaction) {
        TransactionHistoryResponse target = new TransactionHistoryResponse();
        BeanUtils.copyProperties(transaction, target);
        return target;

    }

    /**
     * Transforms data form transaction history domain list object to  response list object.
     *
     * @param transactionHistoryDomainObjectList the transaction history domain object list
     * @return the list
     */
    public static List<TransactionHistoryResponse> transactionHistoryDomainListToResponseList(List<Transaction> transactionHistoryDomainObjectList) {
        List<TransactionHistoryResponse> transactionHistoryResponseList = new ArrayList<>();
        for (Transaction transaction : transactionHistoryDomainObjectList) {
            TransactionHistoryResponse responseObject = TransactionHistoryDomainToResponse(transaction);
            transactionHistoryResponseList.add(responseObject);
        }
        return transactionHistoryResponseList;
    }

}
