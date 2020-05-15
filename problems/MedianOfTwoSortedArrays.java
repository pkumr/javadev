public class MedianOfTwoSortedArrays{
	public double findMedianSortedArrays(int[] nums1, int[] nums2){
		int m = nums1.length;
		int n = nums2.length;
		
		if(m > n)
			return findMedianSortedArrays(nums2, nums1);

		int imin = 0;
		int imax = m;
		while(imin <= imax){
			int i = imin + (imax - imin) / 2;
			int j = (m + n + 1) / 2 - i;

			int A_left = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
			int A_right = i == m ? Integer.MAX_VALUE : nums1[i];
			int B_left = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
			int B_right = j == n ? Integer.MAX_VALUE : nums2[j];

			if(A_left > B_right){
				imax = i - 1;
			}else if (B_left > A_right){
				imin = i + 1;
			}else {
				int max_left = A_left > B_left ? A_left : B_left;
				int min_right = A_right > B_right ? B_right : A_right;
				if((m + n) % 2 == 1){
					return max_left;
				}
				else {
					return (max_left + min_right) / 2.0;
				}
			}
		}
		return - 1;
	}
}