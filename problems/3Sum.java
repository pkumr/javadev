import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

public class 3Sum {
    /*
    *
    * Given an array nums of n integers, are there elements a, b, c 
    * in nums such that a + b + c = 0? Find all unique triplets in 
    * the array which gives the sum of zero.
    *
    */
    public List<List<Integer>> threeSumTP(int[] nums){
        List<List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length;  i++){
            if(i == 0 || nums[i - 1] != nums[i])
                twoSumII(nums, i, result);
        return result;
    }



    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                while(low < high){
                    if(nums[low] + nums[high] == sum){
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low + 1]) low++;
                        while(low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    }else if (nums[low] + nums[high] < sum){
                        low++;
                    }else{
                        high--;
                    }
                }
            }
        }
        return result;
    }
}
