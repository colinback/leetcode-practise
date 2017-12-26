package shizy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array S of n integers, are there elements a, b, c, 
 * and d in S such that a + b + c + d = target? Find all unique 
 * quadruplets in the array which gives the sum of target.
 * 
 * Note: The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * 
 * [
 * 	[-1,  0, 0, 1],
 * 	[-2, -1, 1, 2],
 * 	[-2,  0, 0, 2]
 * ]
 */
public class Practise018 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise018 p = new Practise018();
		
		// [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
		System.out.println(p.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
		// [[0,0,0,0]]
		System.out.println(p.fourSum(new int[] {0, 0, 0, 0}, 0));
		// [[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
		System.out.println(p.fourSum(new int[] {-3, -2, -1, 0, 0, 1, 2, 3}, 0));
		// [[-4, 0, 1, 2], [-1, -1, 0, 1]]
		System.out.println(p.fourSum(new int[] {-1, 0, 1, 2, -1, -4}, -1));
		// [[-5,-5,-1,4],[-5,-3,-1,2]]
		System.out.println(p.fourSum(new int[] {-1, -5, -5, -3, 2, 5, 0, 4}, -7));
	}

    public List<List<Integer>> fourSum(int[] nums, int target) {
    		// 排序
    		Arrays.sort(nums);
    		System.out.println(Arrays.toString(nums));
    		
    		List<List<Integer>> list = new ArrayList<List<Integer>>();
    		
    		for(int i = 0; i < nums.length - 3; i++) {
    			// skip same result
			if (i > 0 && nums[i] == nums[i-1])
				continue;
				
    			for(int j = i+1; j < nums.length - 2; j++) {
    				// skip same result
    				if (i != j-1 && nums[j] == nums[j-1])
    					continue;
    				
    				// target is now target - nums[i] - nums[j]
    				int goal = target - nums[i] - nums[j];
    				int lo = j+1, hi = nums.length-1;
    				
    				while(lo < hi) {
    					if (nums[lo] + nums[hi] == goal) {
    						list.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
    						
    						// skip same result;
    						while(lo < hi && nums[lo] == nums[lo+1]) lo++;
    						while(lo < hi && nums[hi] == nums[hi-1]) hi--;
    						
    						lo++; hi--;
    					} else if(nums[lo] + nums[hi] < goal) 
    						lo++;
    					else
    						hi--;
    				}
    			}
    		}
    		return list;
    }
}
