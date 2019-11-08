package shizy.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Given an array S of n integers, are there elements a, b, c in S such that 
 * a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * 	[-1, 0, 1],
 * 	[-1, -1, 2]
 * ]
 */
public class Practise015 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise015 p = new Practise015();
		
		System.out.println(p.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums); 
		// {-4, -1, -1, 0, 1, 2}
		
		List<List<Integer>> list = new LinkedList<>();
		
		for(int i = 0; i< nums.length - 2; i++) {
			// skip same result
			if (i > 0 && nums[i] == nums[i-1])
				continue;
			
			int lo = i+1, hi = nums.length - 1;
			int target = - nums[i];
			while(lo < hi) {
				if (nums[lo] + nums[hi] == target) {
					list.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
					
					//skip same result
					while(lo < hi && nums[lo] == nums[lo+1]) lo++;
					while(lo < hi && nums[hi] == nums[hi-1]) hi--;
					
					lo++; hi--;
				} else if (nums[lo] + nums[hi] < target)
					lo++;
				else
					hi--;
			}
		}
        return list;
    }
}
