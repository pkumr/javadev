/*************************************************************************
*@author Parveen Kumar
*Description: 	Given an array of integers, return indices of two numbers
*				such that they add up to a specific target.
*
***************************************************************************/
import java.util.*;

public class _1_Two_Sum{
	//****************Brute Force Approach*******************
	//Time Compexity - O(N-Square)
	public int[] twoSum_bruteforce(int[] nums, int target) {

        //Consider nums = {1, 2, 3, 4, 5} and target = 7
        //for loop with variable from 1 to 5
        for(int i = 0; i < nums.length; i++){
            //second for loop pick one element for i position
            // and walk through the elements next to i position
            for(int j = i + 1; j < nums.length; j++){
                //if element at j position is equal to target (7) - number at position i
                //exaample -->nums[j = 3]= 4 == 7(target) - nums[i=2] = 3 
                if(nums[j] == target - nums[i]){
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No Two Sum Solution");
    }

    //*******************Using Hash Table***************************
    public int[] twoSum_hashtable(int[] nums, int target) {
        /*************Using Hash Table - Space - O(N) and Time - O(N)***/
        Map<Integer, Integer> htab = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            //iterate through array, add values and 
            //positions of values in hash table
            htab.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            //take the difference that comes from subtracting value at ith position
            //Go to hash table, check if we have key in hashtable --htab.containsKey(diff) -- true
            //and also check if diff value is not at ith position
            if(htab.containsKey(diff) && htab.get(diff) != i){
                return new int[] {i, htab.get(diff)};
            }
        }
        throw new IllegalArgumentException("No Two Solutions");
    }

}