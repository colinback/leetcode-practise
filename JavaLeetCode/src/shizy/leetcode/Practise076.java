package shizy.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.List;

/*
 * Given a string S and a string T, find the minimum window in S which 
 * will contain all the characters in T in complexity O(n).
 * 
 * For example,
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC".
 * 
 * Note:
 * If there is no such window in S that covers all characters in T, 
 * return the empty string "".
 * 
 * If there are multiple such windows, you are guaranteed that there 
 * will always be only one unique minimum window in S.
 */
public class Practise076 {
	public static void main(String[] args) {
		Practise076 p = new Practise076();
		System.out.println(p.minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(p.minWindow("a", "aa"));
	}

	public String minWindow(String s, String t) {
		if (s.length() == 0 || t.length() == 0) {
			return "";
		}

		// Dictionary which keeps a count of all the unique characters in t.
		Map<Character, Integer> dict = new HashMap<>();
		for (char ch : t.toCharArray()) {
			dict.put(ch, dict.getOrDefault(ch, 0) + 1);
		}

		// keep track of how many unique characters in t are present in the
		// current window in its desired frequency.
		int count = 0;

		// keep track of minimum window size
		int window_size = Integer.MAX_VALUE;

		// return string
		String ret = "";

		for (int i = 0, j = 0; j < s.length(); j++) {
			char ch = s.charAt(j);

			if (dict.containsKey(ch)) {
				// update dict
				dict.put(ch, dict.get(ch) - 1);
				if (dict.get(ch) == 0)
					count++;

				// all characters in t are found
				while (i <= j && count == dict.size()) {
					// s[i, j]
					if (j - i + 1 < window_size) {
						window_size = j - i + 1;
						ret = s.substring(i, j + 1);
					}

					// Try and contract the window from left
					ch = s.charAt(i);
					if (dict.containsKey(ch)) {
						dict.put(ch, dict.get(ch) + 1);
						if (dict.get(ch) > 0)
							count--;
					}

					i++;
				}
			}
		}

		return ret;
	}
}
