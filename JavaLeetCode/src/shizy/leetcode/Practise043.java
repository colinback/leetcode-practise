package shizy.leetcode;

import java.util.Arrays;

/*
 * Given two non-negative integers num1 and num2 represented as strings, 
 * return the product of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.

 */
public class Practise043 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise043 p = new Practise043();
		System.out.println(p.multiply("123456", "456789"));
		//System.out.println(p.multiply("456789", "456789"));
		//System.out.println(p.multiply("456789", "0"));
		//System.out.println(p.multiply("0", "0"));
		System.out.println(p.multiply("1", "1"));
		System.out.println(p.multiply("6913259244", "71103343"));
	}

    public String multiply(String num1, String num2) {
    		if (num1.equals("0") || num2.equals("0")) {
    			return "0";
    		}
    	
    		int[] intResult = new int[num1.length() + num2.length()];
    		char[] numArr1 = num1.toCharArray(); 
    		char[] numArr2 = num2.toCharArray();
	 
    		for(int i = numArr1.length - 1; i >= 0; i--) {
    			for(int j = numArr2.length - 1; j >= 0; j--) {
		 		int n1 = Character.getNumericValue(numArr1[i]);
		 		int n2 = Character.getNumericValue(numArr2[j]);
		 		int pos = num1.length() + num2.length() - 2 - i - j;
		 		
		 		intResult[pos] += n1 * n2;
		 		
		 		// 处理进位
		 		int value = intResult[pos] /10;
		 		intResult[pos] = intResult[pos] %10;
		 		//intResult[pos+1] 可能超过10留到下一次循环处理
		 		intResult[pos + 1] += value;
    			}
    		}
    		
    		StringBuffer ret = new StringBuffer();
    		int pos =  num1.length() + num2.length() -1;
    		while (intResult[pos] == 0) pos--;
    		
    		for(; pos >=0; pos--) {    			
    			ret.append(intResult[pos]);
    		}
    		
    		return ret.toString();
    }
}
