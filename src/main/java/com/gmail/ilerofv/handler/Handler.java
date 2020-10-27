package com.gmail.ilerofv.handler;

import com.gmail.ilerofv.entity.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class Handler {
    public static List<Double> report(List<Transaction> transactions, Date from, Date to, String merchant) {
        List<Double> report = new ArrayList<>();
        List<Transaction> filtered = transactions.stream()
                .filter(item -> item.getMerchant().equals(merchant))
                .filter(item -> item.getDate().compareTo(from) > 0)
                .filter(item -> item.getDate().compareTo(to) < 0)
                .collect(Collectors.toList());
        double count = filtered.size();
        report.add(count);
        double sum = filtered.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
        report.add(sum/count);
        return report;
    }
}
