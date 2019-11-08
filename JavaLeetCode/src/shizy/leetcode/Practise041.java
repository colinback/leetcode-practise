package shizy.leetcode;

import java.util.Arrays;

/*
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class Practise041 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise041 p = new Practise041();
		System.out.println(p.firstMissingPositive(new int[] {1, 2, 0}));
		System.out.println(p.firstMissingPositive(new int[] {3, 4, -1, 1}));
		System.out.println(p.firstMissingPositive(new int[] {1, 2, 3, 7}));
		System.out.println(p.firstMissingPositive(new int[] {2, 3, 7, 5, 4, 1}));
		
		System.out.println(p.firstMissingPositive(new int[] {1, 1}));
	}

	public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        
        for(int i = 0; i < len; i++) {
        		// nums[i] != nums[nums[i]-1] 防止重复数字
        		// 否则可以nums[i] != i+1
        		while(nums[i] > 0 && nums[i] < len && nums[i] != nums[nums[i] - 1])
        			swap(nums, i, nums[i] - 1);
        }
        
        System.out.println(Arrays.toString(nums));
        
        for(int i = 0; i < len; i++) {
        		if (nums[i] != i + 1)
        			return i+1;
        }
        
        return len + 1;
    }
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
