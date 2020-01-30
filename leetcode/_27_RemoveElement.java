public class _27_RemoveElement{
	/*
	* Given nums = [3,2,2,3], val = 3,
	*
	* Your function should return length = 2, 
	*  with the first two elements of nums being 2.
	*
	*It doesn't matter what you leave beyond the returned length.
	*/

	 public int removeElement(int[] nums, int val) {
        int pointer = 0;
        for(int i : nums){
            if(i != val){
                nums[pointer++] = i;
            }
        }
        return pointer;
    }
}