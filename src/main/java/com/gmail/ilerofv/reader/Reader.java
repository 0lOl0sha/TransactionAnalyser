package com.gmail.ilerofv.reader;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Reader {
    public List<String[]> read(String filePath) {
        List<String[]> list = new ArrayList<>();
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
            while ((nextLine = reader.readNext()) != null) {
                //Verifying the read data here=
                list.add(nextLine);
            }
        } catch (IOException | CsvValidationException e) {
            //TODO нормальная ошибка
            e.printStackTrace();
        }
        return list;
    }
}

