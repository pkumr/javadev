/*
 * 642
 */
package com.pk.algorithms.design;
import java.util.List;
import java.util.LinkedList;
/**
 *
 * @author parveenkumar
 */
public class SearchAutocompleteSystem {
    class Node{
        String sentence;
        int times;
        Node(String st, int t){
            sentence  = st;
            times = t;
        }
    }
    class Trie {
        int times;
        Trie[] branches = new Trie[27];
    }
    public int int_(char c){
        return c == ' ' ? 26 : c - 'a';
    }
    
    public void insert (Trie t, String s, int times){
        for(int i = 0; i < s.length(); i++){
            if(t.branches[int_(s.charAt(i))] == null)
                t.branches[int_(s.charAt(i))] = new Trie();
            t = t.branches[int_(s.charAt(i))];
        }
        t.times += times;
    }

    public SearchAutocompleteSystem(String[] sentences, int[] times) {
        
    }
    
    public List<String> input(char c) {
        List<String> output  = new LinkedList<>();
        return output;
    }
}
