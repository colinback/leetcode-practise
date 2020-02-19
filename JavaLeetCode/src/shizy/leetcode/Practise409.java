package shizy.leetcode;

import java.util.Set;
import java.util.HashSet;

/*
 * Given a string which consists of lowercase or uppercase letters, find the
 * length of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * 
 * Input:
 * "abccccdd"
 * Output:
 * 7
 * 
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class Practise409 {
	public static void main(String[] args) {
		Practise409 p = new Practise409();
		System.out.println(p.longestPalindrome("abccccdd"));
		System.out.println(p.longestPalindrome("bb"));
		System.out.println(p.longestPalindrome(""));
	}

	public int longestPalindrome(String s) {
		Set<Character> chars = new HashSet<>();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (chars.contains(s.charAt(i))) {
				chars.remove(s.charAt(i));
				count += 2;
			} else {
				chars.add(s.charAt(i));
			}
		}

		if (chars.isEmpty())
			return count;
		else
			return count + 1;
	}
}
