package com.gmail.ilerofv.utils;

import com.gmail.ilerofv.entity.Transaction;
import com.gmail.ilerofv.entity.TransactionType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionCreator {
    private static final Logger logger = LogManager.getLogger(TransactionCreator.class);

    public static Transaction createTransaction(String[] params){
        return  Transaction.builder()
                .id(params[0].trim())
                .date(stringToDate(params[1].trim()))
                .amount(Double.parseDouble(params[2].trim()))
                .merchant(params[3].trim())
                .transactionType(TransactionType.valueOf(params[4].trim()))
                .related(params[5].trim())
                .build();
    }

    public static Date stringToDate (String date){
        SimpleDateFormat formatter =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            logger.error(e.toString(), e);
            throw new RuntimeException(e);
        }
    }

}
