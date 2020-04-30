package com.interview.goog.process;

import java.util.Map;
import java.util.HashMap;

public class _904_FruitIntoBaskets {
    public static void main(String[] args) {
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(new _904_FruitIntoBaskets().totalFruit(fruits));
    }
    public int totalFruitSW(int[] tree){
        //Pending Solutions
        return 0;
    }
    public int totalFruit(int[] tree) {
        if(tree == null || tree.length == 0)
            return 0;
        int max_count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int first_pointer = 0;
        int second_pointer = 0;
        while (second_pointer < tree.length){
            if(map.size() <= 2)
                map.put(tree[second_pointer], second_pointer++);

            if(map.size() > 2){
                int min = tree.length - 1;
                for(int value : map.values()){
                    min = Math.min(min, value);
                }
                first_pointer = min + 1;
                map.remove(tree[min]);
            }
            max_count = Math.max(max_count, second_pointer - first_pointer);
        }
        return max_count;
    }
}