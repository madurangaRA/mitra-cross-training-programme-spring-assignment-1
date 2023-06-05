package com.mitra.bank.controller;

import com.mitra.bank.common.RequestMapper;
import com.mitra.bank.domain.Account;
import com.mitra.bank.domain.Transaction;
import com.mitra.bank.service.TransactionService;
import com.mitra.bank.service.dto.*;
import com.mitra.bank.service.transformers.TransactionTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The  Transaction controller handles all transaction related functions
 */
@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    /**
     * Deposits given value from the given account number
     *
     * @param doTransactionRequest the do transaction request
     * @return the do transaction response
     */
    @RequestMapping(value = RequestMapper.DEPOSIT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody DoTransactionResponse deposit(@RequestBody DoTransactionRequest doTransactionRequest) {
        Transaction transaction = TransactionTransformer.doTransactionRequestToDomain(doTransactionRequest);
        Account updatedAccount = transactionService.doTransaction(transaction, "deposit");
        return TransactionTransformer.doTransactionDomainToRequest(updatedAccount);
    }

    /**
     * Withdraws given value from the given account number.
     *
     * @param doTransactionRequest the do transaction request
     * @return the do transaction response
     */
    @RequestMapping(value = RequestMapper.WITHDRAW, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody DoTransactionResponse withdraw(@RequestBody DoTransactionRequest doTransactionRequest) {
        Transaction transaction = TransactionTransformer.doTransactionRequestToDomain(doTransactionRequest);
        Account updatedAccount = transactionService.doTransaction(transaction, "withdraw");
        return TransactionTransformer.doTransactionDomainToRequest(updatedAccount);
    }

    /**
     * Gets transaction history for given account number.
     *
     * @param accountNumber the account number
     * @return the history
     */
    @RequestMapping(value = RequestMapper.HISTORY, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody TransactionsHistoryResponse getHistory(@PathVariable String accountNumber) {
        List<Transaction> transactionsDomainObjectList = transactionService.getHistory(accountNumber);
        List<TransactionHistoryResponse> responseObjectList = TransactionTransformer.transactionHistoryDomainListToResponseList(transactionsDomainObjectList);
        TransactionsHistoryResponse response = new TransactionsHistoryResponse();
        response.setTransactions(responseObjectList);
        return response;
    }
}
