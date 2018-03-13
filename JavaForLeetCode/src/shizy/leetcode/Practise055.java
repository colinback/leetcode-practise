package shizy.leetcode;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */

public class Practise055 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise055 p = new Practise055();
		System.out.println(p.canJump(new int[] {2,7,3,1,4}));
		System.out.println(p.canJump(new int[] {3,2,1,0,4}));
		System.out.println(p.canJump(new int[] {0}));
	}

	public boolean canJump(int[] nums) {		
		int maxPos = 0;
		
        for(int i = 0; i < nums.length; i++) {
        		if(maxPos >= i) {
	        		maxPos = Math.max(maxPos, i + nums[i]);
	        		if (maxPos >= nums.length - 1)
	        			return true;
        		}
        }
        
        return false;
    }
}
