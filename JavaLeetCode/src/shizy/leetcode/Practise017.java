package shizy.leetcode;

import java.util.LinkedList;
import java.util.List;

/*
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 1			2(abc)		3(def)
 * 4(ghi)	5(jkl)		6(mno)
 * 7(pqrs)	8(tuv)		9(wxyz)
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Practise017 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise017 p =  new Practise017();
		System.out.println(p.letterCombinations("23"));
		System.out.println(p.letterCombinations(""));
	}

//	public List<String> letterCombinations(String digits) {
//		String[] codes = new String[] {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//		
//		LinkedList<String> res = new LinkedList<String>();
//		res.add("");
//		
//        for(int i = 0; i < digits.length(); i++) {
//        		int number = Character.getNumericValue(digits.charAt(i));
//        		// System.out.println(number);
//        		
//        		while(res.peek().length() == i) {
//        			String str = res.remove();
//        			for(char ch : codes[number-1].toCharArray())
//        				res.add(str + ch);
//        		}
//        }
//        
//        res.remove("");  
//        return res;
//    }
	
	public List<String> letterCombinations(String digits) {
		return letterCombinations(new LinkedList<String>(), digits, digits.length()-1);
    }
	
	public List<String> letterCombinations(List<String> list, String digits, int bit) {
		String[] codes = new String[] {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		if (bit < 0) return new LinkedList<String>();
		
		List<String> res = new LinkedList<String>();
		int number = Character.getNumericValue(digits.charAt(bit));
		if (bit == 0 ) {
			for(char ch : codes[number-1].toCharArray())
				res.add(Character.toString(ch));
		} else {
			for(String s: letterCombinations(list, digits, bit-1))
				for(char ch : codes[number-1].toCharArray())
					res.add(s + ch);
		}
		
		return res;
	}
 }
