package com.problems;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class _22_GenerateParentheses {
    public static void main(String[] args){
        int input = 3;
        System.out.println("Output: - " + new _22_GenerateParentheses().
                generateParenthesis(input));
    }
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
}
