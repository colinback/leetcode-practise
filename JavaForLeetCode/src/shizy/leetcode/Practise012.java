package shizy.leetcode;

/*
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 *  1 - I
 *  5 - V
 *  10 - X
 *  50 - L
 *  100 - C
 *  500 -D
 *  1000 - M
 */
public class Practise012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise012 p = new Practise012();
		System.out.println(p.intToRoman(108));
		System.out.println(p.intToRoman(397));
		System.out.println(p.intToRoman(10));
		System.out.println(p.intToRoman(50));
	}

	public String intToRoman_recursive(int num) {
		if (num == 0)
			return "";
		
		if (num >= 1000)
			return "M" + intToRoman(num - 1000);
		else if (num >= 900)
			return "CM" + intToRoman(num - 900);
		else if (num >= 500)
			return "D" + intToRoman(num - 500);
		else if (num >= 400)
			return "CD" + intToRoman(num - 400);
		else if (num >= 100)
			return "C" + intToRoman(num - 100);
		else if (num >= 90)
			return "XC" + intToRoman(num - 90);
		else if (num >= 50)
			return "L" + intToRoman(num - 50);
		else if (num >= 40)
			return "XL" + intToRoman(num - 40);
		else if (num >= 10)
			return "X" + intToRoman(num - 10);
		else if (num == 9)
			return "IX"; 
		else if (num >=5)
			return "V" + intToRoman(num - 5);
		else if (num == 4)
			return "IV";
		else return "I" + intToRoman(num -1);
    }
	
	public String intToRoman(int num) {
	    String M[] = {"", "M", "MM", "MMM"};
	    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	    
	    return M[num/1000] + C[(num%1000)/100]+ X[(num%100)/10] + I[num%10];
	}
}
