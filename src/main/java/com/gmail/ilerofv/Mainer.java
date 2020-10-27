package com.gmail.ilerofv;

import com.gmail.ilerofv.entity.Creator;
import com.gmail.ilerofv.entity.Transaction;
import com.gmail.ilerofv.reader.Reader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Mainer {

    public static void main(String[] args) {
        Reader reader = new Reader();
        List<Transaction> list = reader.read("data/data.csv");
        list.forEach(item -> System.out.println(item));
       /* Map<String,Transaction> relevant = list.get(0) ;
        Map<String,Transaction> deleted = list.get(1) ;
        System.out.println("relevant");
        printMap(relevant);
        System.out.println("deleted");
        printMap(deleted);*/
    }
    public static void printMap(Map mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }
}
