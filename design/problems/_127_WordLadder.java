package com.revision.mar2020;
/*
* Description : Given two words (beginWord and endWord), and a dictionary's word list,
* find the length of shortest transformation sequence from beginWord to endWord, such that:
*
* 1. Only one letter can be changed at a time.
* 2. Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
*
* Note:
*   Return 0 if there is no such transformation sequence.
*   All words have the same length.
*   All words contain only lowercase alphabetic characters.
*   You may assume no duplicates in the word list.
*   You may assume beginWord and endWord are non-empty and are not the same.
*
* Example: 1
*
* Input:
*   beginWord = "hit",
*   endWord = "cog",
*   wordList = ["hot","dot","dog","lot","log","cog"]
*
* Output: 5
* Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
* return its length 5.
*
* Example : 2
*
* Input:
* beginWord = "hit"
* endWord = "cog"
* wordList = ["hot","dot","dog","lot","log"]
*
* Output: 0
* Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*
* */
import java.util.*;

public class _127_WordLadder {
    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordlist = {
                "hot","dot","dog","lot","log","cog"
        };
        int output = new _127_WordLadder().ladderLength(beginWord, endWord, Arrays.asList(wordlist));
        System.out.println("Output " + output);
    }
    private int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //If WordList doesn't contain endWord, we cannot make ladder
        //from beginWord to endWord!
        if(!wordList.contains(endWord))
            return 0;
        //Put all words in wordList to HashSet
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        int length = 0;
        //set.add(endWord);
        queue.add(beginWord);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String word = queue.poll();
                if(word.equals(endWord))
                    return length + 1;
                wordMatch(word, set, queue);
            }
            length++;
        }
        return 0;
    }
    private void wordMatch(String word, Set<String> set, Queue<String> queue){
        for(int i = 0; i < word.length(); i++){
            char[] w  = word.toCharArray();
            for(int j = 0; j < 26; j++){
                char c = (char)('a' + j);
                //System.out.println("Char C : " + c);
                if(w[i] == c) continue;
                w[i] = c;
                String s = String.valueOf(w);
                //System.out.println("String s : " + s);
                if(set.contains(s)){
                    set.remove(s);
                    queue.offer(s);
                }
            }
        }
    }
}
