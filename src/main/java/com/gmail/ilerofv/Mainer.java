package com.gmail.ilerofv;

import com.gmail.ilerofv.entity.Creator;
import com.gmail.ilerofv.reader.Reader;
import java.util.Arrays;
import java.util.List;

public class Mainer {

    public static void main(String[] args) {
        Reader reader = new Reader();
        List<String[]> list = reader.read("data/data.csv");
        list.forEach (line -> System.out.println(Arrays.toString(line) + " " + line.length)
        );
        list.remove(0);
        list.forEach (line -> System.out.println(Creator.create(line)));
    }

}
