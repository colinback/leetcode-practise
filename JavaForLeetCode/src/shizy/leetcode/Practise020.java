package shizy.leetcode;

import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class Practise020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise020 p = new Practise020();
		
		System.out.println(p.isValid("()"));
		System.out.println(p.isValid("()[]{}"));
		System.out.println(p.isValid("[{}]"));
		System.out.println(p.isValid("(]"));
		System.out.println(p.isValid("([)]"));
		System.out.println(p.isValid("["));
		System.out.println(p.isValid("]"));
	}
	
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			} else {
				if (stack.isEmpty())
					return false;
				
				char left = stack.pop();
				if ((left == '(' && ch != ')') || (left == '[' && ch != ']') || (left == '{' && ch != '}'))
					return false;
			}
		}
		
		return stack.isEmpty();
    }
	
//	public boolean isValid(String s) {
//		Stack<Character> stack = new Stack<Character>();
//		for (char c : s.toCharArray()) {
//			if (c == '(')
//				stack.push(')');
//			else if (c == '{')
//				stack.push('}');
//			else if (c == '[')
//				stack.push(']');
//			else if (stack.isEmpty() || stack.pop() != c)
//				return false;
//		}
//		return stack.isEmpty();
//	}
}
