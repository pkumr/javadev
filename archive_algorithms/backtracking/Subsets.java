package com.pk.algorithms.backtracking;

/**
 *
 * @author parveenkumar
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Subsets {
    public List<List<Integer>> subsets(int[] nums){
        //Create a list object to save the result
        List<List<Integer>> list = new ArrayList<>();
        //Sort the input array
        Arrays.sort(nums);
        //Call backtrac function to generate the subset and store result in list
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    //Function for backtracking
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
