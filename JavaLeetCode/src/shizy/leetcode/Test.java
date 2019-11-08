package shizy.leetcode;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test();
		String[] strs = new String[] {"abc", "abcde", "abcff"};
		System.out.println(t.longestCommonPrefix(strs));
	}

    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) return "";
        
        StringBuffer sb = new StringBuffer();
        longestCommonPrefix(strs, 0, sb);
        return sb.toString();
    }
	    
    private void longestCommonPrefix(String[] strs, int index, StringBuffer sb) {
        if (strs[0].length() <= index) return;
        
        char ch = strs[0].charAt(index);
        System.out.println(ch);
        
        for(int i = 1; i < strs.length; i++) {
            if (strs[i].length() <= index) return;
            else if (strs[i].charAt(index) != ch) return;
        }
        
        sb.append(ch);
        longestCommonPrefix(strs, index + 1, sb);
    }
}
