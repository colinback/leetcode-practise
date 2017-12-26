package shizy.leetcode;

/*
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 */
public class Practise029 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise029 p = new Practise029();
		
		// MAX_VALUE 2147483647
		// MIN_VALUE -2147483648
//		System.out.println(p.divide(9, 3));
//		System.out.println(p.divide(11, 4));
//		System.out.println(p.divide(5, -4));
//		System.out.println(p.divide(-9, -3));
//		System.out.println(p.divide(0, 1));
//		System.out.println(p.divide(-1, 1));  // -1
//		System.out.println(p.divide(-2147483648, -1));
		System.out.println(p.divide(-2147483648, 1));
//		System.out.println(p.divide(-1010369383, -2147483648));
	}

    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
      
        int sign = 1;  
        if ( (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
        		sign = -1;
        
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        
        long res = ldivide(ldividend, ldivisor);
        
        if (res > Integer.MAX_VALUE) 
        		return sign == 1 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
        
        return (int)(res * sign);
    }
    
    private long ldivide(long ldividend, long ldivisor) {
    		if (ldividend < ldivisor) return 0;
    		
    		long sum = ldivisor;
    		long multiple = 1;
    		while(ldividend > sum + sum) {
    			sum = sum + sum;
    			multiple = multiple + multiple;
    		}
    		
    		return multiple + ldivide(ldividend - sum, ldivisor);
    }
}
