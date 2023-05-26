package com.mitra.bank.domain;


import java.util.Date;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Account {

    @Id
    @Column(name = "account_number")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "nic")
    private String nic;
}
