package shizy.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/*
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Example 1:
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * 
 * Example 2:
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * 
 * Example 3:
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * 
 * Example 4:
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 */
public class Practise290 {
	public static void main(String[] args) {
		Practise290 p = new Practise290();
		System.out.println(p.wordPattern("abba", "dog cat cat dog"));
		System.out.println(p.wordPattern("abba", "dog cat cat fish"));
		System.out.println(p.wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(p.wordPattern("abba", "dog dog dog dog"));
	}

	public boolean wordPattern(String pattern, String str) {
		char[] pats = pattern.toCharArray();
		String[] strs = str.split(" ");

		if (pats.length != strs.length)
			return false;

		Map<Character, String> map = new HashMap<>();

		for(int i = 0; i < pats.length; i++) {
			if (map.containsKey(pats[i])) {
				if (!map.get(pats[i]).equals(strs[i]))
					return false;
			} else {
				if (map.containsValue(strs[i]))
					return false;

				map.put(pats[i], strs[i]);
			}
		}

		return true;
    }
}
