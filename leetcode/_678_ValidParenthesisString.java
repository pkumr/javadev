public class _678_ValidParenthesisString{
	public boolean checkValidString(String s) {
        //Take a stack for left '(' brackets
        Stack<Integer> leftID = new Stack<>();
        //Take a stack for '*' 
        Stack<Integer> starID = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                //if '(' is found, push that index of string in stack
                leftID.push(i);
            else if (ch == '*')
                //if '*' is found, push that index of string in stack
                starID.push(i);
            else { //cases for ')' brackets
                //if no left '(' or * exits befor ')', then return false
                if (leftID.isEmpty() && starID.isEmpty())   return false;
                // if '(' exits and we find, ')', pop from left stack
                if (!leftID.isEmpty())
                    leftID.pop();
                else // if '*' exists and we find ')' pop fom star stack
                    starID.pop();
            }
        }
        //Check for left '(' and '*' only, means no ')' in input string
        while (!leftID.isEmpty() && !starID.isEmpty()) {
            //we pop left bracket and *
            //if left exits before *, poped index value will be less then poped index value of *
            //in case poped index value is greated for starID -> example:  *( , return false. 
            if (leftID.pop() > starID.pop()) 
                return false;
        }
        //return status of leftID stack
        return leftID.isEmpty();
    }
}