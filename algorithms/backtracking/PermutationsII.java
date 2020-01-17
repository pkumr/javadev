
package com.pk.algorithms.backtracking;

/**
 * Input has duplicates
 * @author parveenkumar
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> list  = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        }else{
            for(int i = 0; i < nums.length; i++){
                //Bounding Functions for backtracking.
                if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
