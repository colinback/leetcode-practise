package shizy.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3 
 * 
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Practise003 {

	public static void main(String[] args) {
		Practise003 p = new Practise003();
		System.out.println(p.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(p.lengthOfLongestSubstring("bbbbb"));
		System.out.println(p.lengthOfLongestSubstring("pwwkew"));

		System.out.println(p.lengthOfLongestSubstring("c"));
		System.out.println(p.lengthOfLongestSubstring("tmmzuxt"));
		System.out.println(p.lengthOfLongestSubstring("bbtablud"));
	}

	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int count = 0;

		for (int start = 0, end = 0; end < s.length(); end++) {
			Character ch = s.charAt(end);

			// this is the most important: find max between map.get(ch) and current start
			// position
			if (map.containsKey(ch))
				start = Math.max(map.get(ch) + 1, start);

			// refresh maxinum between ans and num
			count = Math.max(count, end - start + 1);

			// insert or update (ch, i) into hashmap
			map.put(ch, end);
		}
		return count;
	}
}
