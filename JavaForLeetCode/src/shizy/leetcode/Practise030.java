package shizy.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * You are given a string, s, and a list of words, words, 
 * that are all of the same length. Find all starting indices 
 * of substring(s) in s that is a concatenation of each word 
 * in words exactly once and without any intervening characters.
 * 
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * 
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class Practise030 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise030 p = new Practise030();
		System.out.println(p.findSubstring("barfoothefoobarman", new String[] {"foo", "bar"}));
		System.out.println(p.findSubstring("barfoofoobarthefoobarman", new String[] {"bar","foo","the"}));
//		System.out.println(p.findSubstring("", new String[] {"foo", "bar"}));
//		System.out.println(p.findSubstring("ooaaooaa", new String[] {"oo", "aa"}));
		
	}

	/* Time Limit Exceeded */
//    public List<Integer> findSubstring(String s, String[] words) {
//    		List<Integer> list = new ArrayList<Integer>();
//    		int wordLength = words[0].length();
//    		
//    		for(int i = 0; i <= s.length() - wordLength; i++) {
//    			List<String> wordList = new ArrayList<String>(Arrays.asList(words));
//    			int j = i;
//    			while(j <= s.length() - wordLength && !wordList.isEmpty()) {
//    				String str = s.substring(j, j + wordLength);
//	    			if (wordList.contains(str)) {
//	    				wordList.remove(str);
//	    				j += wordLength;
//	    			} else
//	    				break;
//    			}
//    			if (wordList.isEmpty())
//    				list.add(i);
//    		}
//    		
//    		return list;
//    }

	/* Still Time Limit Exceeded */
//	public List<Integer> findSubstring(String s, String[] words) {
//		List<String> concatedWords = new ArrayList<String>();
//		wordsConcatenation(concatedWords, Arrays.asList(words), 0);
//		
//		int length = concatedWords.get(0).length();
//		List<Integer> list = new ArrayList<Integer>();
//		
//		for(int i = 0; i <= s.length() - length; i++) {
//			String str = s.substring(i, i + length);
//			if (concatedWords.contains(str))
//				list.add(i);
//		}
//		
//		return list;
//	}
//	
//	private void wordsConcatenation(List<String> concate, List<String> words, int k) {
//		if (k == words.size() - 1) {
//			String str = String.join("", words);
//			
//			if (!concate.contains(str))
//				concate.add(str);
//		}
//		
//		for(int i = k; i < words.size(); i++) {
//			Collections.swap(words, i, k);
//			wordsConcatenation(concate, words, k+1);
//			Collections.swap(words, k, i);
//		}
//	}
	
	/* Still Time Limit Exceeded */
//	public List<Integer> findSubstring(String s, String[] words) {
//		Map<String, Integer> counts = new HashMap<>();
//		for(String word : words) {
//			counts.put(word, counts.getOrDefault(word, 0) + 1);
//		}
//		
//		List<Integer> indexes = new ArrayList<>();
//		int n = s.length();
//		int num = words.length;
//		int len = words[0].length();
//		
//		for(int i = 0; i < n - num * len + 1; i++) {
//			Map<String, Integer> seen = new HashMap<>();
//			int j = 0;
//			while(j < num) {
//				String word = s.substring(i + j * len, i + (j + 1) * len);
//				if (counts.containsKey(word)) {
//					seen.put(word, seen.getOrDefault(word, 0) + 1);
//					if (seen.get(word) > counts.getOrDefault(word, 0))
//						break;
//				} else { 
//					break;
//				}
//				j++;
//			}
//			
//			if (j == num)
//				indexes.add(i);
//		}
//		
//		return indexes;
//	}
	
	public List<Integer> findSubstring(String s, String[] words) {		
		int slen = s.length();
		int llen = words.length;
		
		List<Integer> indexes = new ArrayList<>();
		if (slen <= 0 || llen <= 0) return indexes;
		
		int wlen = words[0].length();
		
		// words中可能包含相同字符串，记录个数
		Map<String, Integer> wordsMap = new HashMap<>();
		for(String word: words) {
			wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
		}
		// System.out.println(wordsMap);
		
		for(int i = 0; i < wlen; i++) {
			int left = i, count = 0;
			Map<String, Integer> mapping = new HashMap<>();
			
			for(int j = i; j < slen - wlen + 1; j += wlen) {
				String str = s.substring(j, j + wlen);
				
				if (wordsMap.containsKey(str)) {
					mapping.put(str, mapping.getOrDefault(str, 0) + 1);
					
					if (mapping.get(str) <= wordsMap.get(str))
						count++;
					else {
						// words中某个字符串超出计数，前移left
						while(mapping.get(str) > wordsMap.get(str)) {
							String tmp = s.substring(left, left + wlen);
							mapping.put(tmp, mapping.get(tmp) - 1);
							if (mapping.get(tmp) < wordsMap.get(tmp))
								count--;
							
							left += wlen;
						}
					}
					
					if (count == llen)
						indexes.add(left);				
				} else {
					// s[j..j+wlen]不匹配任何单词，重置count和mapping
					// left右移
					count = 0;
					mapping.clear();
					left = j + wlen;
				}
			}
		}
		
		return indexes;
	}
}
