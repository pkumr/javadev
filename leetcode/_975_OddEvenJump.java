package com.interview.goog.process;


import java.util.Arrays;
import java.util.TreeMap;

public class _975_OddEvenJump {
    public static void main(String[] args){
        _975_OddEvenJump obj = new _975_OddEvenJump();
        int[] input = {10,13,12,14,15};
        System.out.println("Result One :- " + obj.oddEvenJumps(input));

        input = new int[] {2,3,1,1,4};
        System.out.println("Result Two :- " + obj.oddEvenJumps(input));

        input = new int[] {5,1,3,4,2};
        System.out.println("Result Three :- " + obj.oddEvenJumps(input));

    }
    private int oddEvenJumps(int[] A) {
        int N = A.length;
        if(N <= 1)
            return N;
        boolean[] odd = new boolean[N];
        boolean[] even = new boolean[N];
        odd[N - 1] = true;
        even[N - 1] = true;
        TreeMap<Integer, Integer> values = new TreeMap<>();
        values.put(A[N - 1], N - 1);
        //System.out.println(values);
        for(int i = N - 2; i >= 0; i--){
            int val = A[i];
            if(values.containsKey(val)){
                odd[i] = even[values.get(val)];
                even[i] = odd[values.get(val)];
                //System.out.println("odd at " + i + " -  " + odd[i]);
                //System.out.println("even at " + i + " - " + even[i]);
            }else {
                Integer lower  = values.lowerKey(val);
                Integer higher = values.higherKey(val);
                //System.out.println("Lower :- " + lower + " Higher - " + higher);
                if(lower != null){
                    even[i] = odd[values.get(lower)];
                }
                if(higher != null){
                    odd[i] = even[values.get(higher)];
                }
            }
            values.put(val, i);
        }
        System.out.println("TreeMap View:- " + values);
        int answer = 0;

        for(boolean p : odd)
            System.out.print(p + "-->") ;
        System.out.print("\n");
        for(boolean p : even)
            System.out.print(p + "-->") ;
        System.out.print("\n");

        for(boolean b : odd)
            if(b) answer++;
        return answer;
    }
}
