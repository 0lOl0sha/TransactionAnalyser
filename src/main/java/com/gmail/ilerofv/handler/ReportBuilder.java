package com.gmail.ilerofv.handler;

import com.gmail.ilerofv.entity.Report;
import com.gmail.ilerofv.entity.Transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class ReportBuilder {

    public static Report report(List<Transaction> transactions, Date from, Date to, String merchant) {
        List<Transaction> filtered = transactions.stream()
                .filter(item -> item.getMerchant().equals(merchant))
                .filter(item -> item.getDate().compareTo(from) > 0)
                .filter(item -> item.getDate().compareTo(to) < 0)
                .collect(Collectors.toList());
        int count = filtered.size();
        BigDecimal sum = filtered.stream()
                .map(Transaction::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal average;
        if (sum.compareTo(BigDecimal.ZERO) > 0){
            average = sum.divide(BigDecimal.valueOf(count));
        } else { average = BigDecimal.ZERO;}
        return new Report(count, average);
    }

}
