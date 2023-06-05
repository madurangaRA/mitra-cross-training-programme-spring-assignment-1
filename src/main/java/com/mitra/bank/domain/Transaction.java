package com.mitra.bank.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Table(name = "transaction")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Transaction {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "date")
    private Date date;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "amount")
    private double amount;
}
