package com.gmail.ilerofv.reader;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Reader {
    ClassLoader classLoader = getClass().getClassLoader();

    public List<String[]> read(String filePath) {
        URL url = classLoader.getResource(filePath);
        FileReader fileReader = null;
        List<String[]> list = new ArrayList<>();
        if (url != null) {
            try {
                fileReader = new FileReader(new File(url.getFile()));
            } catch (FileNotFoundException e) {
                //TODO нормальная ошибка
                e.printStackTrace();
                return list;
            }
        } else {
            return list;
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

