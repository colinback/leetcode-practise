package shizy.leetcode;

/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class Practise014 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise014 p = new Practise014();
//		System.out.println(p.longestCommonPrefix_bruteforce(new String[] {"abc", "abcde", "abdef"}));
//		System.out.println(p.longestCommonPrefix_bruteforce(new String[] {"c", "c"}));
//		
//		System.out.println(p.longestCommonPrefix_horizontal(new String[] {"abc", "abcde", "abdef"}));
//		System.out.println(p.longestCommonPrefix_vertical(new String[] {"abc", "abcde", "abdef"}));
		
		System.out.println(p.longestCommonPrefix_divideAndConquer(new String[] {"abc", "abcde", "abdef"}));
	}

	// 基本等同于longestCommonPrefix_vertical
	public String longestCommonPrefix_bruteforce(String[] strs) {
		if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        if (strs[0].length() == 0) return "";
        
        StringBuffer sb = new StringBuffer();
        boolean loop = true;
        int curr = 0;
        
        while(loop) {
        		char c = strs[0].charAt(curr);
        		for(int i = 1; i < strs.length; i++) {
        			if (curr >= strs[i].length() || strs[i].charAt(curr) != c) {
        				loop = false;
        				break;
        			}
        		}
        		
        		if (loop) {
        			sb.append(c);
        			curr++;
        		}
        		
        		if (curr >= strs[0].length())
        			loop = false;
        }
        
        return sb.toString(); 
    }
	
	public String longestCommonPrefix_horizontal(String[] strs) {
		if (strs.length == 0) return "";
		String prefix = strs[0];
		
		for(int i = 1; i < strs.length; i++) {
			while( strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty()) return "";
			}
		}
		return prefix;
	}
	
	public String longestCommonPrefix_vertical(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		
		for(int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for(int j = 1; j < strs.length; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != c)
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}
	
	public String longestCommonPrefix_divideAndConquer(String[] strs) {
		if (strs.length < 1) return "";
		if (strs.length == 1) return strs[0];
		
		if (strs.length > 2) {
			int mid = strs.length / 2;
			String lStr = longestCommonPrefix_divideAndConquer(getSubStrings(strs, 0, mid));
			String rStr = longestCommonPrefix_divideAndConquer(getSubStrings(strs, mid, strs.length));
			return longestCommonPrefix_divideAndConquer(new String[] {lStr, rStr});
		}
		
		//strs.length == 2
		String prefix = strs[1];
		while(strs[0].indexOf(prefix) != 0) {
			prefix = prefix.substring(0, prefix.length() - 1);
			if (prefix.isEmpty()) return "";
		}
		return prefix;
	}
	
	private String[] getSubStrings(String[] strs, int start, int end) {
		String[] subStrs = new String[end - start];
		for(int i = start; i < end; i++) {
			subStrs[i-start] = strs[i];
		}
		return subStrs;
	}
}
