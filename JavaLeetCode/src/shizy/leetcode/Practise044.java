package shizy.leetcode;

import java.util.Arrays;

/*
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */
public class Practise044 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise044 p = new Practise044();
		
		System.out.println(p.isMatch("aa", "a"));
		System.out.println(p.isMatch("aa", "aa"));
		System.out.println(p.isMatch("aaa", "aa"));
		System.out.println(p.isMatch("ab", "a?"));
		
		System.out.println();
		System.out.println(p.isMatch("aa", "*"));
		System.out.println(p.isMatch("aa", "a*"));
		System.out.println(p.isMatch("aa", "?*"));
		System.out.println(p.isMatch("aab", "a*b"));
		System.out.println(p.isMatch("aab", "c*a*b"));

		System.out.println();
		System.out.println(p.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
		System.out.println(p.isMatch("", "*"));
		System.out.println(p.isMatch("ho", "**ho"));
		System.out.println(p.isMatch("abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab", "*aabb***aa**a******aa*"));
	}
	
	/* Time Limit Exceeded */
	/*
	public boolean isMatch(String s, String p) {
		int slen = s.length();
		int plen = p.length();
		// System.out.println(s + "," + p);
		
		if (slen == 0 && plen == 0)
			return true;
		
		if (plen == 0)
			return false;
		
		if (slen == 0) {
			if (p.charAt(plen-1) == '*')
				return isMatch(s, p.substring(0, plen-1));
			else
				return false;
		}
		
		// slen != 0 && plen != 0
		switch (p.charAt(plen-1)) {
		case '?':
			return isMatch(s.substring(0, slen-1), p.substring(0, plen-1));
		case '*':	
			return isMatch(s.substring(0, slen-1), p) ||
					isMatch(s.substring(0, slen-1), p.substring(0, plen-1)) ||
					isMatch(s, p.substring(0, plen-1));
		default:
			if (s.charAt(slen-1) != p.charAt(plen-1) )
				return false;
			else
				return isMatch(s.substring(0, slen-1), p.substring(0, plen-1));
		}
	}
	*/ 
	
	public boolean isMatch(String s, String p) {
		int slen = s.length();
		int plen = p.length();
		
		// dp[i][j] means if txt[i:] match pattern[j:]
		boolean[][] dp = new boolean[slen + 1][plen + 1];
		dp[slen][plen] = true;
		
		for(int i = slen; i >= 0; i--) 
			for(int j = plen -1; j >= 0; j--) {
				boolean ith_match = i < s.length() && 
						(p.charAt(j) == '?' || p.charAt(j) == s.charAt(i));

				if (p.charAt(j) == '*') {
					dp[i][j] =  dp[i][j+1] || (i+1 <= slen && dp[i+1][j+1]) || (i+1 <= slen && dp[i+1][j]) ;
				}
				else		
					dp[i][j] = ith_match && dp[i+1][j+1];
				
			}
		
		return dp[0][0];
	}
}
