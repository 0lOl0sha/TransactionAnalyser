package com.gmail.ilerofv.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    private String id;
    private Date date;
    private BigDecimal amount;
    private String merchant;
    private TransactionType transactionType;
    private String related = "";

}
