package shizy.leetcode;

/*
 * The count-and-say sequence is the sequence of integers with 
 * the first five terms as following:
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * 
 * Note: Each term of the sequence of integers will be represented as a string.
 * 
 * Example 1: 
 * Input: 1
 * Output: "1"
 * 
 * Example 2:
 * Input: 4
 * Output: "1211"
 */
public class Practise038 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise038 p = new Practise038();
		
		// 312211
		System.out.println(p.countAndSay(6));
	}

	public String countAndSay(int n) {
        String str = "1";
        
        for(int i = 1; i < n; i++) {
        		str = generateNext(str);
        }
        
        return str;
    }
	
	private String generateNext(String s) {
		StringBuffer sb = new StringBuffer();
		int count = 1;
		for(int i = 1; i <= s.length(); i++) {
			if (i < s.length() && s.charAt(i) == s.charAt(i-1))
				count++;
			else {
				sb.append("" + count + s.charAt(i-1));
				count = 1;
			}
		}
		return sb.toString();
	}
}
