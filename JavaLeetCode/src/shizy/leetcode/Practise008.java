package shizy.leetcode;
/*
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge, 
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 * You are responsible to gather all the input requirements up front.
 */
public class Practise008 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise008 p = new Practise008();
		
//		System.out.println(p.myAtoi("123"));
//		System.out.println(p.myAtoi("0"));
//		System.out.println(p.myAtoi("012"));
//		System.out.println(p.myAtoi("-240"));
//		System.out.println(p.myAtoi("+240"));
//		System.out.println(p.myAtoi(" 456 "));
		
//		System.out.println(p.myAtoi("123456778976676"));
//		System.out.println(p.myAtoi("-"));
//		System.out.println(p.myAtoi("  "));
//		System.out.println(p.myAtoi("      -11919730356x"));
		System.out.println(p.myAtoi("9223372036854775809"));
		System.out.println(p.myAtoi("2147483647"));
	}
	
	public int myAtoi(String str) {
		String s = str.trim();
		int n = s.length();
		if (n == 0) return 0;
		if (n == 1 && (s.charAt(0) < '0' || s.charAt(0) > '9')) return 0;
		
		double result = 0;
		int head = 0;
		int increment = 1;
		
		if (s.charAt(head) == '-') {
			increment = -1;
			head++;
		} else if (s.charAt(head) == '+') {
			head++;
		}
		
		for(int i=head; i<n; i++) {
			if (s.charAt(i) < '0' || s.charAt(i) >'9')
				break;
			
			result = result * 10 + (int)(s.charAt(i) - '0') * increment;
		}
		
		// System.out.println(result);
		if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
		if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		return (int)result;
	}
}
