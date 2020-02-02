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
		Practise055 p = new Practise055();
		System.out.println(p.canJump(new int[] { 2, 7, 3, 1, 4 }));
		System.out.println(p.canJump(new int[] { 3, 2, 1, 0, 4 }));
		System.out.println(p.canJump(new int[] { 0 }));
	}

	public boolean canJump(int[] nums) {
		int lastPos = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (i + nums[i] >= lastPos)
				lastPos = i;
		}

		return lastPos == 0;
	}
}
