package com.gmail.ilerofv.handler;

import com.gmail.ilerofv.entity.Report;
import com.gmail.ilerofv.entity.Transaction;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class Handler {

    public static Report report(List<Transaction> transactions, Date from, Date to, String merchant) {
        List<Transaction> filtered = transactions.stream()
                .filter(item -> item.getMerchant().equals(merchant))
                .filter(item -> item.getDate().compareTo(from) > 0)
                .filter(item -> item.getDate().compareTo(to) < 0)
                .collect(Collectors.toList());
        int count = filtered.size();
        double sum = filtered.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
        double average;
        if (sum > 0){
            average = sum/count;
        } else { average = 0;}
        return new Report(count, average);
    }

}
