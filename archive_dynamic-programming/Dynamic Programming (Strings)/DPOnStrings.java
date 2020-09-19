public class DPOnStrings{
	//General problem statement for this pattern can 
	//vary but most of the time you are given two strings 
	//where lengths of those strings are not big
	//
	//Statement:
	//Given two strings s1 and s2, return some result.
	//
	//Approach:
	//Most of the problems on this pattern requires a solution that 
	//can be accepted in O(n^2) complexity.
	private void MethodType(String s1, String s2){
		// i - indexing string s1
		// j - indexing string s2
		int m = s1.length();
		int n = s2.length();
		int dp[][];
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				if (s1[i-1] == s2[j-1]) {
					dp[i][j] = /*code*/;
				} else {
					dp[i][j] = /*code*/;
				}
			}
		}
	}
	//If you are given one string s the approach may little vary
	private void MethodTypeOneString(String s1){
		int n = s1.length();
		for (int l = 1; l < n; ++l) {
			for (int i = 0; i < n-l; ++i) {
				int j = i + l;
				if (s[i] == s[j]) {
					dp[i][j] = /*code*/;
				} else {
					dp[i][j] = /*code*/;
				}
			}
		}
	}
}