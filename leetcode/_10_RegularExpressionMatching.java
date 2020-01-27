public class _10_RegularExpressionMatching{
	//Using Recursion
	public boolean isMatchRecursion(String s, String p){
		if(p.isEmpty())
			return s.isEmpty();
		boolean first_match = (!s.isEmpty() && 
								(p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

		if(p.length() >= 2 && p.charAt(1) == '*'){
			return (isMatchRecursion(s, p.substring(2)) ||
					(first_match && isMatchRecursion(s.substring(1), p)));
		}else{
			return first_match && isMatchRecursion(s.substring(1), p.substring(1));
		}
	}
	//Using Dynamic Programming
	public boolean isMatchBottomUpDP(String s, String p){
		if(s == null || p == null){
			return false;
		}
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for(int i = 0; i < p.length(); i++){
			if(p.charAt(i) == '*' && dp[0][i - 1]){
				dp[0][i + 1] = true;
			}
		}
		for(int i = 0; i < s.length(); i++){
			for(int j = 0; j < p.length(); j++){
				if(p.charAt(j) == '.'){
					dp[i + 1][j + 1] = dp[i][j];
				}
				if(p.charAt(j) == s.charAt(i)){
					dp[i + 1][j + 1] = dp[i][j];
				}
				if(p.charAt(j) == '*'){
					if(p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) = '.'){
						dp[i + 1][j + 1] = dp[i + 1][j - 1];
					}else{
						dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j+1] || dp[i + 1][j - 1]);
					}
				}
			}
		}
		return dp[s.length()][p.length()];
	}
}