package com.compjava;

/*
@author : Parveen Kumar
*/

import java.io.*;
import java.util.*;

public class JMaps {
    public static void main(String[] args) {
        JMaps obj = new JMaps();
        obj.hMap();
        obj.tMap();
    }
    //HashMap
    private void hMap(){
        //-----------HASH MAP--------------------//
        //Order is not maintained in HashMap. The order is based on hash value
        HashMap<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        map.put("Five", 5);
        //If we put new value to map for existing key, it returns old value
        Object o = map.put("Four", 8);
        System.out.println((int)o);
        //Keys are set so collection of keys is SET
        Set keys = map.keySet();
        System.out.println(keys);
        //Values are collections so to get values
        Collection c = map.values();
        System.out.println(c);
        //Entry is the pair of key and value in map
        Set entrySet = map.entrySet();
        Iterator it = entrySet.iterator();
        while (it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            System.out.println("Entry Key : " + entry.getKey() + " || Entry Value : " + entry.getValue());
        }
    }

    /*---------------Tree Maps----------------*/
    private void tMap(){
        TreeMap<String, Integer> w_map = new TreeMap<>();
        TreeMap<Integer, String> i_map = new TreeMap<>();

        w_map.put("xene", 1);
        w_map.put("rene", 2);
        w_map.put("aene", 3);
        w_map.put("gene", 4);
        w_map.put("oene", 5);

        i_map.put(3, "h");
        i_map.put(2, "e");
        i_map.put(9, "k");
        i_map.put(1, "u");
        i_map.put(5, "z");

        System.out.println(w_map);
        System.out.println(i_map);

        System.out.println(w_map.headMap("oene"));
        System.out.println(w_map.tailMap("oene"));

        System.out.println(i_map.firstKey());
        System.out.println(i_map.lastKey());
        System.out.println(i_map.subMap(2, 5));

        //Poll will remove the entry
        Map.Entry<Integer, String> entryFirst = i_map.pollFirstEntry();
        Map.Entry<Integer, String> entryLast = i_map.pollLastEntry();

        System.out.println("First Entry : " + entryFirst + " Last Entry : " + entryLast );
        System.out.println(i_map);
    }
}
