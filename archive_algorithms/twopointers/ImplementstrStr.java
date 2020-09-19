/*
 * 
 */
package com.pk.algorithms.twopointers;

/**
 *
 * @author parveenkumar
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        for (int start = 0; start < n - L + 1; ++start) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }
}
