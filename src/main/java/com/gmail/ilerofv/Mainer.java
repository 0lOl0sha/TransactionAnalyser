package com.gmail.ilerofv;

import com.gmail.ilerofv.utils.Creator;
import com.gmail.ilerofv.entity.Transaction;
import com.gmail.ilerofv.handler.Handler;
import com.gmail.ilerofv.utils.Reader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.Date;
import java.util.List;

public class Mainer {
    private static Logger logger = LogManager.getLogger(Mainer.class);
    static {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }
    public static void main(String[] args) {
        Reader reader = new Reader();
        List<Transaction> transactions = reader.read("data/data.csv");
        Date from = Creator.stringToDate("20/08/2018 12:45:30");
        Date to = Creator.stringToDate("21/08/2018 13:12:20");
        String merchant = "Kwik-E-Mart";
        List<Double> report = Handler.report(transactions, from, to, merchant);
        logger.info("Number of transactions = " + report.get(0).intValue());
        logger.info("Average Transaction Value = " + String.format("%.2f", report.get(1)));
    }

}
