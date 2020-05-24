public class ClimbingStairs{
	/*
	You are climbing a stair case. It takes n steps to reach to the top.
	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	Note: Given n will be a positive integer.

	we take all possible step combinations i.e. 1 and 2, at every step. At every step we are calling 
	the function climbStairs for step 1 and 2, and return the sum of returned values of both functions.
	
	climbStairs(i,n)=(i+1,n)+climbStairs(i+2,n)

	where i defines the current step and n defines the destination step
	*/

	//Approach# - Recursion with Memoization
	public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climb_stairs(0, n, memo);
    }
    public int climb_stairs(int i, int n, int memo[]){
        if(i > n){
            return 0;
        }
        if(i == n){
            return 1;
        }
        if(memo[i] > 0){
            return memo[i];
        }
        memo[i] = climb_stairs(i + 1, n, memo) + climb_stairs(i + 2, n, memo);
        return memo[i];
    }
}