package shizy.leetcode;

import java.util.Arrays;

/*
 * Given an array S of n integers, find three integers in S such that 
 * the sum is closest to a given number, target. Return the sum of the 
 * three integers. You may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 *  The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Practise016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise016 p = new Practise016();
		
		System.out.println(p.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
		System.out.println(p.threeSumClosest(new int[]{-1, 0, 1, 9}, 8));
		System.out.println(p.threeSumClosest(new int[]{-100, 0, 1, 9}, 8));
		System.out.println(p.threeSumClosest(new int[]{-3, -2, -5, 3, -4}, -1));
	}

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if(nums.length < 3) throw new IllegalArgumentException("given array has less integer than 3");
        
        // int closest = nums[0] + nums[1] + nums[nums.length - 1];
        int closest = nums[0] + nums[1] + nums[2];
        
        for(int i=0; i < nums.length - 2; i++) {
        		int lo = i+1, hi = nums.length-1;
        		
        		// do the binary search
        		while(lo < hi) {
        			int sum = nums[i] + nums[lo] + nums[hi];
    				
        			// update closest
        			if (Math.abs(target - sum) < Math.abs(target - closest) ) {
        				closest = sum;
        			}
        			
        			if (sum == target)
        				return target;
        			
        			if (sum <= target)
        				lo++;
        			else 
        				hi--;
        		}
        }
        
        return closest;
    }
}
