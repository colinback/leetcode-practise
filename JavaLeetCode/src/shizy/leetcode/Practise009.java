package shizy.leetcode;

/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class Practise009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise009 p = new Practise009();
		
//		System.out.println(p.isPalindrome(313));
//		System.out.println(p.isPalindrome(1));
//		System.out.println(p.isPalindrome(-121));
//		System.out.println(p.isPalindrome(12325));
//		System.out.println(p.isPalindrome(1221));
		System.out.println(p.isPalindrome(12321));
		System.out.println(p.isPalindrome(1000021));
	}

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 & x != 0)) return false;

        int rNum = 0;
        int lNum = x;
        while(rNum < lNum) {
        		rNum = rNum * 10 + lNum % 10;
        		lNum = lNum / 10;
        }
        
        return lNum == rNum || lNum == rNum / 10;
    }
}
