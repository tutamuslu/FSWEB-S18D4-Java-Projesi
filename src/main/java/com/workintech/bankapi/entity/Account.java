package com.workintech.bankapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "account", schema = "bank")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "account_name")
    @NotNull
    private String accountName;

    @Column(name = "money_amount")
    @NotNull
    private double moneyAmount;

    @NotNull
    @OneToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customerId;
}
