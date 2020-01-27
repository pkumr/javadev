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
}