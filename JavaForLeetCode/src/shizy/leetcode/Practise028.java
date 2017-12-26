package shizy.leetcode;

/*
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, 
 * or -1 if needle is not part of haystack.
 * 
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * 
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 */
public class Practise028 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise028 p = new Practise028();
		
//		System.out.println(p.strStr("hello", "ll"));
//		System.out.println(p.strStr("aaaaa", "bba"));
//		System.out.println(p.strStr("ababa", "ba"));
//		System.out.println(p.strStr("", "a"));
//		System.out.println(p.strStr("", ""));
//		System.out.println(p.strStr("mississippi", "issip"));
		
		System.out.println(p.strStr("mississippi", "issip"));
		System.out.println(p.strStr("ababa", "ba"));
	}
	
//	public int strStr(String haystack, String needle) {
//		if (needle.isEmpty()) return 0;
//		if (haystack.isEmpty()) return -1;
//		
//		for(int i = 0; i < haystack.length(); i++) {
//			if (i + needle.length() > haystack.length())
//				return -1;
//			
//			int j = 0;
//			for(j = 0; j < needle.length(); j++) {
//				if (haystack.charAt(i+j) != needle.charAt(j))
//					break;
//			}
//			
//			if (j == needle.length())
//				return i;
//		}
//		
//		return -1;
//	}
	
	// KMP algorithm
	public int strStr(String haystack, String needle) {
		if (needle.isEmpty()) return 0;
		if (haystack.isEmpty()) return -1;

		int[] next = CalculateNext(needle);
		int i = 0, j = 0;
		
		while(i < haystack.length() && j < needle.length()) {
			if (j == 0 && haystack.charAt(i) != needle.charAt(j)) {
				i++;
				continue;
			}
			
			if (haystack.charAt(i) == needle.charAt(j)) {
				i++; j++;
			} else {
				// from j position back to next[j] 
				j = next[j-1];
			}
		}
		
		if (j == needle.length())
			return i-j;
		
		return -1;
	}
	
	private int[] CalculateNext(String target) {
		int next[] = new int[target.length()];
		next[0] = 0;
		
		int n = 0;
		//动态规划求出target[0]... target[m]的最长相同前后缀，即
		// target[0]...target[k] == target[m-k]...target[m] (k <= m)
		for(int m = 1; m < target.length(); m++) {
			while( n > 0 && target.charAt(n) != target.charAt(m))
				n = next[n-1];
			
			if (target.charAt(n) == target.charAt(m))
				n++;
			
			next[m] = n;
		}
		
		return next;
	}
}
