/*************************************************************************
*@author Parveen Kumar
*Description: 	Given an array of integers, return indices of two numbers
*				such that they add up to a specific target.
*
***************************************************************************/
public class _1_Two_Sum{

	public int[] twoSum_bruteforce(int[] nums, int target) {
        //****************Brute Force Approach*******************
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