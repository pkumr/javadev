import java.util.*;
public class _215_Kth_Largest_Element_in_an_Array{
  //Approach#1 : Brute Force Approach
  public int findKthLargest(int[] nums, int k){
    Arrays.sort(nums);
    return nums[nums.length - k];
  }

  //Approach#2 : Using Heap Datastructure
  public int findKthLargestMinHeap(int[] nums, int k){
    PriorityQueue<Integer> minheap = new PriorityQueue<>();
    for(int num : nums){
      minheap.add(num);
      if(minheap.size() > k){
        minheap.remove();
      }
    }
    return minheap.poll();
  }
}
