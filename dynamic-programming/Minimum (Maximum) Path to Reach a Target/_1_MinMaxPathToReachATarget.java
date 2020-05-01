public class _1_MinMaxPathToReachATarget{
	//Minimum (Maximum) Path to Reach a Targe
	//Generate problem statement for this pattern
	//
	//Statement: 
	//Given a target find minimum (maximum) cost / path / sum to reach the target.
	//
	//Approach:
	//Choose minimum (maximum) path among all possible 
	//paths before the current state, then add value for the current state.
	//
	//routes[i] = min(routes[i-1], routes[i-2], ... , routes[i-k]) + cost[i]
	//
	//Generate optimal solutions for all values in the target and return the value for the target.
	private int MethodType(int target, int[] ways){
		int dp[];
		for (int i = 1; i <= target; ++i) {
			for (int j = 0; j < ways.size(); ++j) {
				if (ways[j] <= i) {
					dp[i] = min(dp[i], dp[i - ways[j]]);// + cost / path / sum;
				}
			}
		}
		return dp[target];
	}
}