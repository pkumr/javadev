/*
 * 10	Regular Expression Matching	StringDynamic ProgrammingBacktracking	Hard	1/9/2020
 * 173	Binary Search Tree Iterator	StackTreeDesign	Medium	1/9/2020
 * 31	Next Permutation	Array	Medium	1/9/2020
 * 167	Two Sum II - Input array is sorted	ArrayTwo PointersBinary Search	Easy	1/9/2020
 * 88	Merge Sorted Array	ArrayTwo Pointers	Easy	1/9/2020
 * 653	Two Sum IV - Input is a BST	Tree	Easy	1/9/2020
 *
 * */
package com.programming.problems.twenty;

public class RegularExpressionMatch {
    public static void main(String[] args) {
        String s = "xvb";
        String p = "..b";
        boolean result = new RegularExpressionMatch().isMatchSimple(s, p);
        System.out.println(result);

        s = "ab";
        p = ".*c";
        result = new RegularExpressionMatch().isMatchRecursion(s, p);
        System.out.println(result + "--> with repeating (more than 2) character in string!");

        s = "bbccaa";
        p = "b*c.a*";
        result = new RegularExpressionMatch().isMatchRecursion(s, p);
        System.out.println(result + "--> without repeating character in string!");


        s = "abb";
        p = ".b*";
        result = new RegularExpressionMatch().isMatchDP(s, p);
        System.out.println(result + "--> with DP Program");
        /*
        String parveen = "Kumar";
        for (int i = 0; i < parveen.length(); i++) {
            System.out.println(parveen.substring(i) + "-->");
        }*/
    }
    /*
     * LeetCode# 10 : -> Given an input string (s) and a pattern (p), implement regular expression
     * matching with support for '.' and '*'.
     *       '.' Matches any single character.
     *       '*' Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     *
     * */

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

    //Recursion with Star (*) and Dot (.)
    private boolean isMatchRecursion(String text, String pattern) {
        if (pattern.isEmpty())
            return text.isEmpty();
        boolean fistMatch = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) ||
                pattern.charAt(0) == '.'));
        //First thing to note is (*) works with preceding element.
        //So pattern should be of minimum length of 2 and * can be at second position charAt(1)
        //Return based on two cases
        //1. first recursive is with actual text and dropping two initial characters of pattern.
        //      here as * starts from 2nd position so dropping letter and *
        //2. drop one character in text and call recursive and tie this with first match result.
        //      here if we have repeating character and * matches with them
        //      so we are dropping one character in text
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatchRecursion(text, pattern.substring(2)) ||
                    (fistMatch && isMatchRecursion(text.substring(1), pattern)));
        }
        //this is similar whe we dont have * in pattern
        else {
            return fistMatch && isMatchRecursion(text.substring(1), pattern.substring(1));
        }
    }

    private boolean isMatchDP(String s, String p){
        if (s == null || p == null) {
            return false;
        }
        /*
         * dp = {
         * { true, false, false, false },
         * { false, true, false, false },
         * { false, false, true, true },
         * { false, false, false, true}
         * }
         * */
        // above is final dp with input in main
        //  s = "abb";
        //  p = ".b*";
        // dp[0][0] is marked true;
        //
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                System.out.println("[0][" + (i + 1)+ "]");
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
