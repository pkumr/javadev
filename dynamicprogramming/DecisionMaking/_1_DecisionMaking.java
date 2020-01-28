public class _1_DecisionMaking{
	//The general problem statement for this pattern is forgiven 
	//situation decide whether to use or not to use the current state.
	// So, the problem requires you to make a decision at a current state.
	//Statement:
	//Given a set of values find an answer with an option to choose or ignore the current value.
	//
	//Approach:
	//If you decide to choose the current value use the previous result where the value was ignored; 
	//vice-versa, if you decide to ignore the current value use previous result where value was used.
	private void MethodType(int[] arr, int n, int k){
		// i - indexing a set of values
		// j - options to ignore j values
		for (int i = 1; i < n; ++i) {
			for (int j = 1; j <= k; ++j) {
				//Sample Code-->
				//dp[i][j] = max({dp[i][j], dp[i-1][j] + arr[i], dp[i-1][j-1]});
				//dp[i][j-1] = max({dp[i][j-1], dp[i-1][j-1] + arr[i], arr[i]});
			}
		}
	}
}