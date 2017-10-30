package shizy.leetcode;

/*
 * Given a string s, find the longest palindromic substring in s. 
 * You may assume that the maximum length of s is 1000.
 * 
 * Example:
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * Example:
 * 
 * Input: "cbbd"
 * Output: "bb"
 */
public class Practise005 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise005 p = new Practise005();
		
//		System.out.println(p.longestPalindrome_bruteforce("a"));
//		System.out.println(p.longestPalindrome_bruteforce("babad"));
//		System.out.println(p.longestPalindrome_bruteforce("cbbd"));
		
//		System.out.println(p.longestPalindrome_dp("a"));
//		System.out.println(p.longestPalindrome_dp("babad"));
//		System.out.println(p.longestPalindrome_dp("cbbd"));
//		System.out.println(p.longestPalindrome_dp("aaaa"));
		
		System.out.println(p.longestPalindrome_manacher("aaaa"));
		System.out.println(p.longestPalindrome_manacher("a"));
		System.out.println(p.longestPalindrome_manacher("babcbabcbaccba"));
	}
	
	public String longestPalindrome_bruteforce(String s) {
		int len = s.length();
		String result = "";
		for(int i = 0; i< len; i++) {
			for(int j = i + 1; j <= len; j++) {
				if(isPalindrome(s.substring(i, j)) && (j-i > result.length()))
					result = s.substring(i, j);
			}
		}
		return result;
	}
	
	private boolean isPalindrome(String s) {
		int len = s.length();
		for(int p = 0; p < len; p++) {
			if (s.charAt(p) != s.charAt(len - p - 1))
				return false;
		}
		return true;
	}
	
	public String longestPalindrome_dp(String s) {
		int len = s.length();
		boolean P[][] = new boolean[len][len];
		String result = "";
				
		for(int i = len-1; i >= 0; i--) {
			for(int j = i; j < len; j++) {
				if (s.charAt(i) == s.charAt(j) && (j < i+2 || P[i+1][j-1])) {
					P[i][j] = true;
					if (j-i+1 > result.length())
						result = s.substring(i, j+1);
				}
			}
		}
		return result;
	}
	
	/*
	 *           2         7       11      15        20
	 *           L         i'      C       i         R
	 *   T = # b # a # b # c # b # a # b # c # b # a # c # c # b # a #
	 *   P = 0 1 0 3 0 1 0 7 0 1 0 9 0 1 0 ?
	 */
	public String longestPalindrome_manacher(String s) {
		String T = preProcess(s);
		int n = T.length();
		int[] P = new int[n];
		int C = 0, R = 0;
		
		for(int i = 1; i < n-1; i++) {
			int i_mirror = 2 * C - i; // i' = C - (i - C)
			
			P[i] = (R > i) ? Math.min(R-i, P[i_mirror]) : 0;
			
			while(T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i]))
				P[i]++;
				
			if (i + P[i] > R) {
				C = i;
				R = i + P[i];
			}
		}
		
		int maxLen = 0;
		int centerIndex = 0 ;
		for(int i = 1; i < n - 1; i++) {
			if (P[i] > maxLen) {
				maxLen = P[i];
				centerIndex = i;
			}
		}
		return s.substring((centerIndex - 1 - maxLen)/2, (centerIndex - 1 + maxLen)/2);
	}
	
	// Transform s into T.
	// For example, s = "abba", T = "^#a#b#b#a#$".
	// ^ and $ signs are sentinels appended to each end to avoid bounds checking
	private String preProcess(String s) {
		int n = s.length();
		if (n == 0) return "^$";
		StringBuffer sb = new StringBuffer("^");
		for (int i = 0; i < n; i++) {
			sb.append("#" + s.charAt(i));
		}
		sb.append("#$");
		return sb.toString();
	}
}
