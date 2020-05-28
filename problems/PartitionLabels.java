package com.problems;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args){
        String S = "ababcbacadefegdehijhklij";
        System.out.println("Output :- " + new _763_PartitionLabels().partitionLabels(S));
    }
    //Greedy Approach
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for(int i = 0; i < S.length(); i++){
            last[S.charAt(i) - 'a'] = i;
        }
        int j = 0, a = 0;
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < S.length(); i++){
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if(i == j){
                answer.add(i - a + 1);
                a = i + 1;
            }
        }
        return answer;
    }
}
