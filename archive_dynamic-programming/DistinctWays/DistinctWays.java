public class DistinctWays{
	//Distinct Ways
	//
	//Statement:
	//Given a target find a number of distinct ways to reach the target.
	//
	//Approach:
	//Sum all possible ways to reach the current state.
	//
	//routes[i] = routes[i-1] + routes[i-2], ... , + routes[i-k]
	//
	//Generate sum for all values in the target and return the value for the target.
	private int MethodType(int target, int[] ways){
		int dp[];
		for (int i = 1; i <= target; ++i) {
			for (int j = 0; j < ways.size(); ++j) {
				if (ways[j] <= i) {
					dp[i] += dp[i - ways[j]];
				}
			}
		}
		return dp[target];
	}
}