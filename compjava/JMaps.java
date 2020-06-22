package com.compjava;

import java.util.*;

public class JMaps {
    public static void main(String[] args) {
        JMaps obj = new JMaps();
        obj.hMap();
    }
    //HashMap
    private void hMap(){
        //-----------HASH MAP--------------------//
        //Order is not maintained in HashMap. The order is based on hash value
        Map<String, Integer> map = new HashMap<>();
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
}
