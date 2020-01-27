public class _11_ContainerWithMostWater{
	public int maxArea(int[] height){
		//Two Pointer Approach
		int maxarea = 0; //return variable
		int l = 0; // left (first) pointer
		int r = height.length - 1; //right (2nd) pointer
		//1. increase left and decrease right by 1 each time and
		//2. calculate the area between left and right and update in return variable
		//3. with each iteration check if we get more value of area then previous,
		// update return variable
		while(l < r){
			maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
			if(height[l] < height[r])
				l++;
			else {
				r--;
			}
		}
		return maxarea;
	}
}