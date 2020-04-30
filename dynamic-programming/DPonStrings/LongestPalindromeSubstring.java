/*
 * 5 Given a string s, find the longest palindromic substring in s. 
 *  You may assume that the maximum length of s is 1000.
 *  
 *
 */
package com.pk.algorithms.dynamicprogramming;

/**
 *
 * @author parveenkumar
 */
public class LongestPalindromeSubstring {
    //Driver
    public static void main_LPS(String[] args){
        String input = "cbbd";
        System.out.println(new LongestPalindromeSubstring().longestPalindrome(input));
    }
    public String longestPalindrome(String s){
        if(s == null || s.length() < 1)
            return "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int startIndex = 0; //Start Index of Palindrome String (Longest String)
        int maxLength = 1; //Max(Longest) Length of Palindrome String
        //Every String with one character is palindrome
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;
        }
        for(int start = s.length()-1; start >= 0 ; start--){
            for (int end = start + 1; end < s.length(); end++){
                 System.out.println(start);
                 System.out.println(end);
                if(s.charAt(start) == s.charAt(end)){
                    //If input is two character string or
                    // if the remaining string is palindrome
                    if(end - start == 1 || dp[start + 1][end - 1]){
                        dp[start][end] = true;
                    }
                }
                if(dp[start][end] && end - start + 1 > maxLength){
                    maxLength = end - start + 1;
                    startIndex = start;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }
}
