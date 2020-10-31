package com.gmail.ilerofv.utils;

import com.gmail.ilerofv.entity.Transaction;
import com.gmail.ilerofv.entity.TransactionType;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class TransactionReader {
    private static final Logger logger = LogManager.getLogger(TransactionReader.class);
    private List<Pair> deleted = new ArrayList<>();

    private class Pair {
        private Transaction deleted;
        private Transaction deleter;

        Pair(Transaction deleted, Transaction deleter) {
            this.deleted = deleted;
            this.deleter = deleter;
        }
    }

    public List<Transaction> readCsv(String filePath) {
        Map<String, Transaction> relevant = new LinkedHashMap<>();
        FileReader fileReader = null;
        try {
            File file = new File(filePath);
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            logger.error(e.toString(), e);
            throw new RuntimeException(e);
        }
        try (CSVReader reader = new CSVReader(fileReader)) {
            //Read CSV line by line and use the string array as you want
            String[] nextLine;
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                Transaction transaction = TransactionCreator.createTransaction(nextLine);
                if (transaction.getTransactionType().equals(TransactionType.REVERSAL)) {
                    Transaction deletedTransaction = relevant.remove(transaction.getRelated());
                    deleted.add(new Pair(deletedTransaction, transaction));
                } else {
                    relevant.put(transaction.getId(), transaction);
                }
            }
        } catch (IOException | CsvValidationException e) {
            logger.error(e.toString(), e);
            throw new RuntimeException(e);
        }
        return new ArrayList<>(relevant.values());
    }

}

