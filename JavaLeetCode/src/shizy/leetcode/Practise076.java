package shizy.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string S and a string T, find the minimum window in S which 
 * will contain all the characters in T in complexity O(n).
 * 
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
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
		// TODO Auto-generated method stub
		Practise076 p = new Practise076();
		System.out.println(p.minWindow("ADOBECODEBANC", "ABC"));
	}

    public String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        
        if (slen <= 0 || tlen <= 0) return "";
        
        Map<Character, Integer> charMap = new HashMap<>();
        for(char ch: t.toCharArray()) {
        		charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }
        
        Map<Character, Integer> mapping = new HashMap<>();
        int minWindow = Integer.MAX_VALUE;
        
        // i -> start pointer, j -> end pointer
        int i = 0, j = 0;
        int count = 0;
        String ret = "";
        
        for(; j < slen; j++) {
        		char cj = s.charAt(j);
        		if (charMap.containsKey(cj)) {
        			mapping.put(cj, mapping.getOrDefault(cj, 0) + 1);
    				if (mapping.get(cj) <= charMap.get(cj))
    					count++;
        		}
        		
        		while(count == tlen) {
        			if (j - i + 1 < minWindow) {
        				minWindow = j - i + 1;
        				ret = s.substring(i, j+1);
        			}
        			
        			char ci = s.charAt(i);
        			if (charMap.containsKey(ci)) {
        				mapping.put(ci, mapping.get(ci) - 1);
        				if (mapping.get(ci) < charMap.get(ci))
        					count--;
        			}
        			i++;
        		}
        }
        
        return ret;
    }
}
