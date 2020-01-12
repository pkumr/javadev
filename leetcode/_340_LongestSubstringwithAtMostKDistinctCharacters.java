public class _340_LongestSubstringwithAtMostKDistinctCharacters{
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n*k == 0) return 0;
        //Parameters for sliding window approach
        int left = 0;
        int right = 0;
        int max_length = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        while(right < n){
            map.put(s.charAt(right), right);
            right++;
            if(map.size() == k + 1){
                int index = Collections.min(map.values());
                map.remove(s.charAt(index));
                left = index + 1;
            }
            max_length = Math.max(max_length, right - left);
        }
        return max_length;
    }
}