package com.compjava;

import java.util.*;

public class JSets {
    public static void main(String[] args) {
        JSets obj = new JSets();
        obj.HSet();
        obj.TSet();
    }
    public void HSet(){
        HashSet<Integer> set = new HashSet<>();
        set.add(101);
        set.add(105);
        set.add(107);
        set.add(105);
        set.add(108);
        set.add(102);
        set.add(108);
        System.out.println("Hash Set :" + set);

        Integer[] arr = new Integer[set.size()];
        set.toArray(arr);
        for(Integer i : arr)
            System.out.print(i + ", ");
        System.out.println();

        if(set.contains(108)){
            set.remove(108);
        }
        System.out.println("Hash Set :" + set);
    }
    public void TSet(){
        TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        set.add(101);
        set.add(105);
        set.add(107);
        set.add(105);
        set.add(108);
        set.add(102);
        set.add(108);
        System.out.println("Tree Set" + set);
        if(set.contains(108)){
            set.remove(108);
        }
        System.out.println("Tree Set" + set);
    }
}
