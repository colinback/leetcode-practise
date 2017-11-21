package shizy.leetcode;

import java.util.HashMap;

/*
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Practise013 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise013 p = new Practise013();
		System.out.println(p.romanToInt("CCCXCVII"));
		System.out.println(p.romanToInt("CVIII"));
		System.out.println(p.romanToInt("X"));
	}

	public int romanToInt(String s) {
		HashMap<Character, Integer> symbol = new HashMap<Character, Integer>() {
			{
				put('I', 1);
				put('V', 5);
				put('X', 10);
				put('L', 50);
				put('C', 100);
				put('D', 500);
				put('M', 1000);
			}
		};
				
		int n = s.length();
		int value = 0;
		for(int i = 0; i < n; i++) {
			int curr = symbol.get(s.charAt(i));
			if ( i+1 < n && curr < symbol.get(s.charAt(i+1)) )
				value -= curr;
			else
				value += curr;
		}
		return value;
	}
}
