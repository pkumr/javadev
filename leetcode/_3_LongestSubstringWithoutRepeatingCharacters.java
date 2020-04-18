package com.interview.goog.arraystring;

import java.util.HashSet;

public class _3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args){
        _3_LongestSubstringWithoutRepeatingCharacters obj =
                new _3_LongestSubstringWithoutRepeatingCharacters();
        String input = "abcabcbb";
        System.out.println("Output : - " + obj.lengthOfLongestSubstring(input));
    }
    private int lengthOfLongestSubstring(String s){
        int a_pointer = 0;
        int b_pointer = 0;
        int max = 0;
        HashSet<Character> hashSet = new HashSet<>();
        while (b_pointer < s.length()){
            if(!hashSet.contains(s.charAt(b_pointer))){
                hashSet.add(s.charAt(b_pointer));
                b_pointer++;
                max = Math.max(hashSet.size(), max);
            }else {
                hashSet.remove(s.charAt(a_pointer));
                a_pointer++;
            }
            //System.out.println(hashSet);
        }
        return max;
    }
}
