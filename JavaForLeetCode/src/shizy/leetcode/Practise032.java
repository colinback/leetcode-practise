package shizy.leetcode;

import java.util.Stack;

/*
 * Given a string containing just the characters '(' and ')', find the 
 * length of the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is 
 * "()()", which has length = 4.
 */
public class Practise032 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise032 p = new Practise032();
		System.out.println(p.longestValidParentheses("(()"));
		System.out.println(p.longestValidParentheses(")()())"));
		System.out.println(p.longestValidParentheses(")())(()())"));
		System.out.println(p.longestValidParentheses("()(()"));
		System.out.println(p.longestValidParentheses("(()"));
		System.out.println(p.longestValidParentheses(")()())()()("));
	}

	/* dynamic programming */
//	public int longestValidParentheses(String s) {
//		int maxLength = 0;
//		int[] dp = new int[s.length()];
//		
//		for(int i = 1; i < s.length(); i++) {
//			if (s.charAt(i) == ')') {
//				if (s.charAt(i-1) == '(')
//					dp[i] = (i > 2 ? dp[i-2] : 0) + 2;
//				else if (i - dp[i-1] > 0 && s.charAt(i - dp[i-1] - 1) == '(')
//					dp[i] = (i - dp[i-1] > 2 ? dp[i - dp[i-1] - 2] : 0) + dp[i-1] + 2;
//				
//				maxLength = Math.max(maxLength, dp[i]);	
//			}
//		}
//		return maxLength;
//    }
	
	public int longestValidParentheses(String s) {
		int maxLength = 0;
		Stack<Integer> stack = new Stack<>();
		
		//dummy
		stack.push(-1);
		
		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				stack.push(i);
			else {
				stack.pop();
				
				if (stack.empty())
					stack.push(i);
				else
					maxLength = Math.max(maxLength, i - stack.peek());
			}
		}
		
		return maxLength;
	}
}
