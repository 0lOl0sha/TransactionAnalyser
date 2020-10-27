package com.gmail.ilerofv.reader;

import com.gmail.ilerofv.entity.Creator;
import com.gmail.ilerofv.entity.Transaction;
import com.gmail.ilerofv.entity.Type;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Reader {

    private List<Pair> deleted = new ArrayList<>();

    private class Pair{
        private Transaction deleted;
        private Transaction deleter;
        Pair (Transaction deleted, Transaction deleter){
            this.deleted = deleted;
            this.deleter = deleter;
        }
    }

    public List<Transaction> read(String filePath) {
        Map<String, Transaction> relevant = new LinkedHashMap<>();
        FileReader fileReader = null;
        try {
            File file = new File(filePath);
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            //TODO обработать
            e.printStackTrace();
            return null;
        }
        try (CSVReader reader = new CSVReader(fileReader)) {
            //Read CSV line by line and use the string array as you want
            String[] nextLine;
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                Transaction transaction = Creator.createTransaction(nextLine);
                if (transaction.getType().equals(Type.REVERSAL)) {
                    Transaction deletedTransaction = relevant.remove(transaction.getRelated());
                    deleted.add(new Pair(deletedTransaction, transaction));
                } else {
                    relevant.put(transaction.getId(), transaction);
                }
            }
        } catch (IOException | CsvValidationException e) {
            //TODO нормальная ошибка
            e.printStackTrace();
        }
        return new ArrayList<>(relevant.values());
    }

}

