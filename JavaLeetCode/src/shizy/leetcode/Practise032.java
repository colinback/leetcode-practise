package shizy.leetcode;

import java.util.Stack;
import java.util.Arrays;

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
		Practise032 p = new Practise032();
		// System.out.println(p.longestValidParentheses("(()"));
		System.out.println(p.longestValidParentheses(")()(()())"));
		System.out.println(p.longestValidParentheses(")())()())"));
	}

	/* dynamic programming */
	public int longestValidParentheses(String s) {
		int n = s.length();
		int count = 0;

		// longest length of valid parentheses substring ending with s[i];
		int[] dp = new int[s.length()];

		for (int i = 1; i < n; i++) {
			// dp[i] = 0 if s[i] is '('
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(')
					dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
				else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(')
					dp[i] = (i - dp[i - 1] > 2 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;

				count = Math.max(count, dp[i]);
			}
		}
		System.out.println(Arrays.toString(dp));

		return count;
	}

	/*
	public int longestValidParentheses(String s) {
		int maxLength = 0;
		Stack<Integer> stack = new Stack<>();

		// dummy
		stack.push(-1);

		for (int i = 0; i < s.length(); i++) {
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
	*/
}
