package shizy.leetcode;

/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number 
 * of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows);
 * 
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class Practise006 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise006 p = new Practise006();
		
		/*
		 * P   A   H   N
		 * A P L S I I G
		 * Y   I   R
		 */
		System.out.println(p.convert("PAYPALISHIRING", 3)); // PAHNAPLSIIGYIR
		
		/*
		 * P     I     N
		 * A   L S   I G
		 * Y A   H R
		 * P     I
		 */
		System.out.println(p.convert("PAYPALISHIRING", 4)); // PINALSIGYAHRPI
		
		System.out.println(p.convert("AB", 1));
		System.out.println(p.convert("AB", 2));
	}

	public String convert(String s, int numRows) {
		if (numRows <= 1) return s;
		
		StringBuffer[] buffers = new StringBuffer[numRows];
        for(int i = 0; i < numRows; i++)
            buffers[i] = new StringBuffer();
		
		int row = 0, incre = 1;
		for(int n = 0; n < s.length(); n++) {
			buffers[row].append(s.charAt(n));
			
			if(row == 0) incre = 1;
			else if (row == numRows-1) incre = -1;
			
			row += incre;
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<numRows; i++)
			sb.append(buffers[i].toString());
		
		return sb.toString();
	}
}
