package com.mitra.bank.repository;

import com.mitra.bank.domain.Account;
import com.mitra.bank.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    @Query("SELECT e FROM Transaction e WHERE e.accountNumber = :accountNumber")
    List<Transaction> findAllByAccountNumber(@Param("accountNumber") String accountNumber);
}


