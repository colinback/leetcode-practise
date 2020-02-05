package shizy.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * Given n pairs of parentheses, write a function to generate all 
 * combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [
 * 	"((()))",
 * 	"(()())",
 * 	"(())()",
 * 	"()(())",
 * 	"()()()"
 * ]
 */
public class Practise022 {
	public static void main(String[] args) {
		Practise022 p = new Practise022();
		
		System.out.println(p.generateParenthesis(3));
	}
	
	// Recursive
	public List<String> generateParenthesis(int n) {
        List<String> outputs = new ArrayList<String>();
        generateParenthesis(outputs, "", 0, 0, n);
        return outputs;
    }
	
	private void generateParenthesis(List<String> ret, String str, int open, int close, int len) {
		if (str.length() == len * 2) {
			ret.add(str);
			return;
		}
		
		if (open < len) {
			generateParenthesis(ret, str + "(", open + 1, close, len);
		}
		
		if (close < open) {
			generateParenthesis(ret, str + ")", open, close + 1, len);
		}
	}
}
