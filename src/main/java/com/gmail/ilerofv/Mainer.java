package com.gmail.ilerofv;

import com.gmail.ilerofv.entity.Report;
import com.gmail.ilerofv.utils.Creator;
import com.gmail.ilerofv.entity.Transaction;
import com.gmail.ilerofv.handler.Handler;
import com.gmail.ilerofv.utils.InputReader;
import com.gmail.ilerofv.utils.ReportWriter;
import com.gmail.ilerofv.utils.TransactionReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.Date;
import java.util.List;
import java.util.Properties;

public class Mainer {
    private static final Logger logger = LogManager.getLogger(Mainer.class);
    static {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }

    public static void main(String[] args) {
        Properties input = InputReader.loadInputInfo();
        TransactionReader transactionReader = new TransactionReader();
        List<Transaction> transactions = transactionReader.readCsv("data/"+input.getProperty("fileName"));
        Date from = Creator.stringToDate(input.getProperty("fromDate"));
        Date to = Creator.stringToDate(input.getProperty("toDate"));
        String merchant = input.getProperty("merchant");
        Report report = Handler.report(transactions, from, to, merchant);
        logger.info(report.toString());
        ReportWriter.writeReport(input.getProperty("reportFileName"), report);
    }

}
