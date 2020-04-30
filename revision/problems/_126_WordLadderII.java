package com.revision.mar2020;
/*
* Given two words (beginWord and endWord), and a dictionary's word list,
* find all shortest transformation sequence(s) from beginWord to endWord, such that:
*
* Only one letter can be changed at a time
* Each transformed word must exist in the word list.
* Note that beginWord is not a transformed word.
*
* Note:
* Return an empty list if there is no such transformation sequence.
* All words have the same length.
* All words contain only lowercase alphabetic characters.
* You may assume no duplicates in the word list.
* You may assume beginWord and endWord are non-empty and are not the same.
*
* Example 1:
*
* Input:
* beginWord = "hit",
* endWord = "cog",
* wordList = ["hot","dot","dog","lot","log","cog"]
*
* Output:
* [
*   ["hit","hot","dot","dog","cog"],
*   ["hit","hot","lot","log","cog"]
* ]
*
*
* Example 2:
*
* Input:
* beginWord = "hit"
* endWord = "cog"
* wordList = ["hot","dot","dog","lot","log"]
*
* Output: []
*
* Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
* */

import java.util.*;

public class _126_WordLadderII {
    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        String[] wordList = {
                "hot", "dot", "dog", "lot", "log", "cog"
        };
        _126_WordLadderII obj = new _126_WordLadderII();
        List<List<String>> res = obj.findLadders(beginWord, endWord, Arrays.asList(wordList));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        return result;
    }

}