package com.problems;



/*
* Given two strings s and t , write a function to determine if t is an anagram of s.
*
* Example 1:
* Input: s = "anagram", t = "nagaram"
* Output: true
*
* Example 2:
* Input: s = "rat", t = "car"
* Output: false
* Note:
* You may assume the string contains only lowercase alphabets.
*
* Follow up:
* What if the inputs contain unicode characters? How would you adapt your solution to such case?
*
* EASY |
* */
import java.util.Arrays;
public class _242_ValidAnagram {
    public static void main(String[] args){
        String s = "anagram";
        String t = "nagaram";
        _242_ValidAnagram obj = new _242_ValidAnagram();
        //Time Complexity => O(NlogN)
        System.out.println(obj.isAnagramSorting(s, t));
        //TimeComplexity => O(N)
        System.out.println(obj.isAnagramHashTable(s, t));
    }
    public boolean isAnagramSorting(String s, String t){
        if(s.length() != t.length())
            return false;
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
    public boolean isAnagramHashTable(String s, String t){
        if(s.length() != t.length())
            return false;
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int value : count) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
