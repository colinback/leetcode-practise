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
		// TODO Auto-generated method stub
		Practise022 p = new Practise022();
		
		System.out.println(p.generateParenthesis(3));
	}
	
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generateParenthesis(res, "", 0, 0, n);
        return res;
    }
	
	private void generateParenthesis(List<String> list, String str, int open, int close, int len) {
		if (str.length() == len * 2) {
			list.add(str);
			return;
		}
		
		if (open < len) {
			generateParenthesis(list, str + "(", open+1, close, len);
		}
		
		if (close < open) {
			generateParenthesis(list, str + ")", open, close+1, len);
		}
	}
}
