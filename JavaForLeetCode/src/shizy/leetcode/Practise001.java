package shizy.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Example:
 * 
 * 	Given nums = [2, 7, 11, 15], target = 9,
 * 	Because nums[0] + nums[1] = 2 + 7 = 9,
 * 	return [0, 1].
 */
public class Practise001 {
	public int[] towSum_bruteforce(int[] nums, int target) throws IllegalArgumentException {
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] {i, j};
				}
			}
		}
		throw new IllegalArgumentException("No tow sum solution");
	}
	
	public int[] towSum_hashmap(int[] nums, int target) throws IllegalArgumentException {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++) {
			if(map.containsKey(target - nums[i]))
				return new int[] {map.get(target - nums[i]), i};
			else if (!map.containsKey(nums[i]))
				map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No tow sum solution");
	}
	
	public static void main(String[] args) {
		Practise001 p = new Practise001();
		
		try {
			int[] result = p.towSum_hashmap(new int[] {3, 3, 4, 11}, 7);
			System.out.println(result[0] + " " + result[1]);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
	}

}
