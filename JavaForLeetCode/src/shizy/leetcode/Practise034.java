package shizy.leetcode;

import java.util.Arrays;

/*
 * Given an array of integers sorted in ascending order, find the 
 * starting and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class Practise034 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise034 p = new Practise034();
		System.out.println(Arrays.toString(p.searchRange(new int[] {5,7,7,8,8,10}, 8)));
		System.out.println(Arrays.toString(p.searchRange(new int[] {5,7,7,8,8,10}, 9)));
		System.out.println(Arrays.toString(p.searchRange(new int[] {5,7,7,8,8,10}, 5)));
		System.out.println(Arrays.toString(p.searchRange(new int[] {5,7,7,8,8,10,10}, 10)));
		System.out.println(Arrays.toString(p.searchRange(new int[] {}, 8)));
	}

	public int[] searchRange(int[] nums, int target) {
        int targetPos = -1;
        
        // 二分法搜索target
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
        		int mid = (lo + hi) /2;
        		
        		if (nums[mid] == target) {
        			targetPos = mid;
        			break;
        		}
        		
        		if (nums[mid] < target)
        			lo = mid + 1;
        		else
        			hi = mid - 1;
        }
        
        // 没有找到target
        if (targetPos == -1)
        		return new int[] {-1, -1};
        
        int starting = targetPos;
        int ending = targetPos;
        // 更新starting/ending
        while(starting >= 0 && nums[starting] == target)
        		starting--;
        while(ending < nums.length && nums[ending] == target)
        		ending++;
        
        return new int[] {starting + 1, ending - 1};
    }
}
