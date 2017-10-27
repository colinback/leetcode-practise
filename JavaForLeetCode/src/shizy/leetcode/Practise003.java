package shizy.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
 * 	
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Practise003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise003 p = new Practise003();
		System.out.println(p.lengthOfLongestSubstring_bruteforce("abcabcbb"));
		System.out.println(p.lengthOfLongestSubstring_bruteforce("bbbbb"));
		System.out.println(p.lengthOfLongestSubstring_bruteforce("pwwkew"));
	
		System.out.println();
		
		System.out.println(p.lengthOfLongestSubstring_hashmap("abcabcbb"));
		System.out.println(p.lengthOfLongestSubstring_hashmap("bbbbb"));
		System.out.println(p.lengthOfLongestSubstring_hashmap("pwwkew"));
		
		System.out.println(p.lengthOfLongestSubstring_hashmap("c"));
		System.out.println(p.lengthOfLongestSubstring_hashmap("tmmzuxt"));
		System.out.println(p.lengthOfLongestSubstring_hashmap("bbtablud"));
	}
	
	private boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for(int i = start; i < end; i++) {
			Character ch = s.charAt(i);
			if(set.contains(ch)) return false;
			set.add(ch);
		}
		return true;
	}
	
	public int lengthOfLongestSubstring_bruteforce(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = 0; i < n; i++) 
        		for(int j= i+1; j <= n; j++)
        			if (allUnique(s, i, j)) ans = Math.max(ans, j-i);
        return ans;
    }

	public int lengthOfLongestSubstring_hashmap(String s) {
		int n = s.length();
		int ans = 0;
		Map<Character, Integer> map = new HashMap<>();
		
		for(int start = 0, end = 0; end < n; end++) {
			Character ch = s.charAt(end);
			// this is the most important: find max between map.get(ch) and current start position
			if (map.containsKey(ch))		
				start = Math.max(map.get(ch) + 1, start);

			// refresh maxinum between ans and num
			ans = Math.max(ans, end - start + 1);
			// insert or update (ch, i) into hashmap
			map.put(ch, end);
		}
		return ans;
	}
}
