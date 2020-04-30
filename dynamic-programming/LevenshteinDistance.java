package com.dp;
    /*
    * Edit Distance (Levenshtein Distance) - Dynamic Programming Problem
    *
    * Given two words word1 and word2, find the minimum number of operations required to convert 
    * word1 to word2.
    * You have the following 3 operations permitted on a word:
    *   - Insert a character
    *   - Delete a character
    *   - Replace a character
    */
public class LevenshteinDistance{
	public int minDistance(String word1, String word2){
		//Create a 2-D dp array to store the results
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		//Fill all columns in first row with 0, 1, 2, 3,...
		for(int i = 0; i < dp[0].length; i++){
			dp[0][i] = i;
		}
		//Fill all rows in first column with values 0, 1, 2, 3, ....
		for(int i = 0; i < dp.length; i++){
			dp[i][0] = i;
		}

		//Two for loops for values
		for(int i = 1; i <= word1.length(); i++){
			for(int j = 1; j <= word2.length(); j++){
				//if the character matches at ith, jth position,
				//fill the same value as left-up diagnoal (go one up and one left)
				if(word1.charAt(i - 1) == word2.charAt(j - 1)){
					dp[i][j] = dp[i - 1][j - 1];
				}
				else{
					//if characters dont match, then minimum of (left, up and diagnoal (left-up))
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
				}
			}
		}
		return dp[word1.length()][word2.length()];
	}

}