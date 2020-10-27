package com.gmail.ilerofv;

import com.gmail.ilerofv.reader.Reader;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class Mainer {

    public static void main(String[] args) throws Exception {

        Reader reader = new Reader();
        List<String[]> list = reader.read("data/data.csv");
        list.forEach (line -> System.out.println(Arrays.toString(line)));

    }

}
