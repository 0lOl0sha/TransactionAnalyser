package com.gmail.ilerofv;

import com.gmail.ilerofv.entity.Creator;
import com.gmail.ilerofv.entity.Transaction;
import com.gmail.ilerofv.handler.Handler;
import com.gmail.ilerofv.reader.Reader;

import java.util.Date;
import java.util.List;

public class Mainer {

    public static void main(String[] args) {
        Reader reader = new Reader();
        List<Transaction> transactions = reader.read("data/data.csv");
        transactions.forEach(System.out::println);
        Date from = Creator.stringToDate("20/08/2018 12:45:30");
        Date to = Creator.stringToDate("21/08/2018 13:12:20");
        String merchant = "Kwik-E-Mart";
        System.out.println(Handler.report(transactions, from, to, merchant));
    }

}
