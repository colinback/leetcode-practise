package shizy.leetcode;
import java.util.Arrays;
import java.util.Comparator;

import java.util.HashMap;

/*
 * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, 
 * please find out a way you can make one square by using up all those matchsticks. You should not break any stick, 
 * but you can link them up, and each matchstick must be used exactly one time.
 * 
 * Your input will be several matchsticks the girl has, represented with their stick length. Your output will either 
 * be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
 * 
 * Example 1:
 * Input: [1,1,2,2,2]
 * Output: true
 * 
 * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 * Example 2:
 * Input: [3,3,3,3,4]
 * Output: false
 * 
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 * 
 * Note:
 * 	1. The length sum of the given matchsticks is in the range of 0 to 10^9.
 * 	2. The length of the given matchstick array will not exceed 15.
 */

public class Practise473 {

	public static void main(String[] args) {
		Practise473 p = new Practise473();
		System.out.println(p.makesquare(new int[] { 1, 1, 2, 2, 2 }));
		System.out.println(p.makesquare(new int[] { 3, 3, 3, 3, 4 }));
	}

	// Backtrace
	public boolean makesquare(int[] nums) {
		if (nums == null || nums.length < 4)
			return false;

		int sum = 0;
		for (int i = 0; i < nums.length; i++)
			sum += nums[i];
		if (sum % 4 != 0)
			return false;

		return backtrace(nums, 0, new int[4], sum / 4);
	}

	private boolean backtrace(int[] nums, int start, int[] sums, int target) {
		if (start == nums.length) {
			if (sums[0] == target && sums[1] == target && sums[2] == target)
				return true;

			return false;
		}

		for (int i = 0; i < 4; i++) {
			if (sums[i] + nums[start] > target)
				continue;

			sums[i] += nums[start];
			if (backtrace(nums, start + 1, sums, target))
				return true;

			sums[i] -= nums[start];
		}

		return false;
	}
}
