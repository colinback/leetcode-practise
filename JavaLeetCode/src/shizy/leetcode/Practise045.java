package shizy.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example:
 * Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. 
 * (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * 
 * Note:
 * You can assume that you can always reach the last index.
 */
public class Practise045 {

	public static void main(String[] args) {
		Practise045 p = new Practise045();
		System.out.println(p.jump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(p.jump(new int[] { 2, 2, 3, 1, 4, 1, 2, 1 }));
		System.out.println(p.jump(new int[] { 0 }));
		System.out.println(p.jump(new int[] { 2, 1 }));
		System.out.println(p.jump(new int[] { 1, 2 }));

		// System.out.println(p.jump(new int[] { 3, 2, 1, 0, 4 }));
		System.out.println(p.jump_dp(new int[] { 2, 3, 1, 1, 4 }));
	}

	// BFS
	public int jump(int[] nums) {
		if (nums.length <= 0)
			return 0;

		int jumps = 0;
		int curr = 0;
		int far = 0;

		for(int i = 0; i < nums.length - 1; i++) {
			far = Math.max(far, i + nums[i]);
			if (i == curr) {
				jumps++;
				curr = far;
			}
		}

		return jumps;
	}

	public int jump_dp(int[] nums) {
		if (nums.length <= 0)
			return 0;
		
		int[] steps = new int[nums.length];
		for(int i = 1; i < nums.length; i++)
			steps[i] = Integer.MAX_VALUE;

		for(int i = 1; i < nums.length; i++) {
			for(int j = 0; j < i; j++) {
				if (j + nums[j] >= i && steps[j] + 1 < steps[i])
					steps[i] = steps[j] + 1;
			}
		}

		return steps[nums.length -1];
	}
}
