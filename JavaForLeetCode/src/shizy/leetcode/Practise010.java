package shizy.leetcode;

/*
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
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
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
public class Practise010 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise010 p = new Practise010();
		
//		System.out.println(p.isMatch_recursive("aa", "a"));
//		System.out.println(p.isMatch_recursive("aa", "aa"));
//		System.out.println(p.isMatch_recursive("aaa", "aa"));
//		System.out.println(p.isMatch_recursive("aa", "a*"));
//		System.out.println(p.isMatch_recursive("aa", ".*"));
//		System.out.println(p.isMatch_recursive("ab", ".*"));
//		System.out.println(p.isMatch_recursive("aab", "c*a*b"));
//		System.out.println(p.isMatch_recursive("ab", ".*c"));
//		System.out.println(p.isMatch_recursive("aaa", "a*a"));
		
//		System.out.println(p.isMatch_dp("aa", "a"));
//		System.out.println(p.isMatch_dp("aa", "aa"));
//		System.out.println(p.isMatch_dp("aaa", "aa"));
//		System.out.println(p.isMatch_dp("aa", "a*"));
//		System.out.println(p.isMatch_dp("aa", ".*"));
//		System.out.println(p.isMatch_dp("ab", ".*"));
//		System.out.println(p.isMatch_dp("aab", "c*a*b"));
//		System.out.println(p.isMatch_dp("ab", ".*c"));
//		System.out.println(p.isMatch_dp("aaa", "a*a"));
		System.out.println(p.isMatch_dp("abbc", "ab*c"));
	}

    public boolean isMatch_recursive(String s, String p) {
    		if (p.isEmpty()) return s.isEmpty();
    		
    		boolean firstCharMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
    		
    		if (p.length() >= 2 && p.charAt(1) == '*') 
    			return isMatch_recursive(s, p.substring(2)) || (firstCharMatch && isMatch_recursive(s.substring(1), p));
    		else
    			return firstCharMatch && isMatch_recursive(s.substring(1), p.substring(1));
    }
    
    public boolean isMatch_dp(String txt, String pattern) {
    		// dp[i][j] means if txt[i:] match pattern[j:]
    		boolean[][] dp = new boolean[txt.length() + 1][pattern.length() + 1];
    		dp[txt.length()][pattern.length()] = true;   // init "" match ""
    		
    		// 
    		for(int i = txt.length(); i >= 0; i--) {
    			for(int j = pattern.length() - 1; j >= 0; j--) {
    				boolean ith_match = i < txt.length() && 
    						(pattern.charAt(j) == '.' || pattern.charAt(j) == txt.charAt(i));
    				
    				if (j+1 < pattern.length() && pattern.charAt(j+1) == '*')
    					dp[i][j] = dp[i][j+2] || (ith_match && dp[i+1][j]);
    				else
    					dp[i][j] = ith_match && dp[i+1][j+1];
    			}
    		}
    		
    		return dp[0][0];
    }
}