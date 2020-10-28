package com.gmail.ilerofv.utils;

import com.gmail.ilerofv.entity.Transaction;
import com.gmail.ilerofv.entity.Type;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Creator {
    private static final Logger logger = LogManager.getLogger(Creator.class);
    public static Transaction createTransaction(String[] params){
        return new Transaction.Builder()
                .withId(params[0].trim())
                .withDate(stringToDate(params[1].trim()))
                .withAmount(Double.parseDouble(params[2].trim()))
                .withMerchant(params[3].trim())
                .withType(Type.valueOf(params[4].trim()))
                .withRelated(params[5].trim())
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
