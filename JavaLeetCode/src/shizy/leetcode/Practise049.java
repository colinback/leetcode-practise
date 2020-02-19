package shizy.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collection;

/*
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
public class Practise049 {

	public static void main(String[] args) {
		Practise049 p = new Practise049();
		System.out.println(p.groupAnagrams(new String[] {
			"eat", "tea", "tan", "ate", "nat", "bat"
		}));
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> words = new HashMap<>();

		for (int i = 0; i < strs.length; i++) {
			char[] chs = strs[i].toCharArray();
			Arrays.sort(chs);  // sort

			String word = String.valueOf(chs);

			if (!words.containsKey(word))
				words.put(word, new ArrayList<>());

			words.get(word).add(strs[i]);
		}

		return new ArrayList<>(words.values());
	}
}
