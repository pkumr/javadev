/*
 * Reference - Leetcode 10
 * 10. Regular Expression Matching
 * 
 * Given an input string (s) and a pattern (p), implement regular expression 
 * matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * 
 * Note:
 * s could be empty and contains only lowercase letters a-z. 
 * p could be empty and contains only lowercase letters a-z, 
 * and characters like . or *.
 * 
 * Example 1:
 * 
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * 
 */
package com.pk.algorithms.dynamicprogramming;

/**
 *
 * @author parveenkumar
 */
public class RegularExpressionMatching {
    //Recursion without Star *
    //If there were no Kleene stars (the * wildcard character for regular expressions), the problem would be easier
    // - we simply check from left to right if each character of the text matches the pattern.
    private boolean isMatchSimple(String text, String pattern) {
        if (pattern.isEmpty())
            return text.isEmpty();
        //First Match below checking 3 conditions
        // 1. if the input string (text) is empty (false). True when string is not empty
        // 2. character at 0 position of text matches with character at 0 position of pattern
        // 3. '.' is present at 0 position - this is true becuase it can be replaced with any
        //      character to match with the text.
        boolean firstMatch = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) ||
                pattern.charAt(0) == '.'));
        //return -->
        // 1. what result we got from firstMatch (True or false) and
        // 2. call the function recursively skipping first character of text and pattern
        return firstMatch && isMatchSimple(text.substring(1), pattern.substring(1));

    }
    
}
