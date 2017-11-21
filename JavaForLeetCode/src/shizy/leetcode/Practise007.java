package shizy.leetcode;
/*
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 	Input: 123
 * 	Output: 321
 * 
 * Example 2:
 * 	Input: -123
 * 	Output: -321
 * 
 * Example 3:
 * 	Input: 120
 * 	Output: 21
 */
public class Practise007 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise007 p = new Practise007();
		
		// System.out.println(p.reverse(123));
		// System.out.println(p.reverse(-123));
		// System.out.println(p.reverse(-5));
		System.out.println(p.reverse(1534236469));
	}
	
	public int reverse(int x) {
		long result = 0;
		while (x != 0) {
			result = result * 10 +  (x % 10);
			if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
				return 0;
			x = x / 10;
		}
		return (int)result;
	}

}
