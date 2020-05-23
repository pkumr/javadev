package com.problems;
/*
* Given an array of strings, group anagrams together.
* Example:
* Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
* Output:
* [
*   ["ate","eat","tea"],
*   ["nat","tan"],
*   ["bat"]
* ]
*
* Note:
*   All inputs will be in lowercase.
*   The order of your output does not matter.
*
* Medium |
* */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class GroupAnagrams {
    public static void main(String[] args){
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        _49_GroupAnagrams obj  = new _49_GroupAnagrams();

        List<List<String>> out =  obj.groupAnagrams(input);
        System.out.println(out);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<>();
        //Edge Cases
        if(strs == null || strs.length == 0)
            return anagrams;
        //Hash Map
        Map<String, List<String>> map = new HashMap<>();
        for(String current : strs){
            char[] ch = current.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(current);
        }
        anagrams.addAll(map.values());
        return anagrams;
    }
}
