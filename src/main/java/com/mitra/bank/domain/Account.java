package com.mitra.bank.domain;

import java.util.Date;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Account {


    @Id
    @Column(name = "account_number")
    @GeneratedValue(generator = "randomLongGenerator")
    @GenericGenerator(name = "randomLongGenerator", strategy = "com.mitra.bank.common.RandomLongIdentifierGenerator")
    private String id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "nic")
    private String nic;

    @Column(name = "balance")
    private double balance;
}
