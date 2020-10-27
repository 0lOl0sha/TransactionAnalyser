package com.gmail.ilerofv.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Creator {
    public static Transaction create(String[] params){
        Creator creator = new Creator();
        return new Transaction.Builder()
                .withId(params[0].trim())
                .withDate(creator.stringToDate(params[1].trim()))
                .withAmount(Double.parseDouble(params[2].trim()))
                .withMerchant(params[3].trim())
                .withType(Type.valueOf(params[4].trim()))
                .withRelated(params[5].trim())
                .build();
    }

    private Date stringToDate (String date){
        SimpleDateFormat formatter =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            //TODO обработать
            e.printStackTrace();
            return null;
        }
    }

}
