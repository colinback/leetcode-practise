package shizy.leetcode;

import java.util.Arrays;

/*
 * Given a sorted array, remove the duplicates in-place such that each element appear 
 * only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying the 
 * input array in-place with O(1) extra memory.
 * 
 * Example:
 * 
 * Given nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 */
public class Practise026 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise026 p = new Practise026();
		int[] input1 = new int[] {1, 1, 2};
		System.out.println(p.removeDuplicates(input1));
		System.out.println(Arrays.toString(input1));
		
		int[] input2 = new int[] {1, 1, 2, 2, 2, 3};
		System.out.println(p.removeDuplicates(input2));
		System.out.println(Arrays.toString(input2));
		
		System.out.println(p.removeDuplicates(new int[] {}));
	}
	
//	public int removeDuplicates(int[] nums) {
//		if (nums.length == 0) return 0;
//		
//        int len = 1;
//        int start = 0, curr = 0;
//        while(curr < nums.length) {
//        		if (nums[curr] == nums[start])
//        			curr++;
//        		else {
//        			// if curr > len, set nums[len] = nums[curr]
//        			if (curr > len) 
//        				nums[len] = nums[curr];
//        			
//        			start = curr++;
//        			len++;
//        		}
//        }
//        return len;
//    }

	public int removeDuplicates(int[] nums) {
	    if (nums.length == 0) return 0;
	    int i = 0;
	    for (int j = 1; j < nums.length; j++) {
	        if (nums[j] != nums[i]) {
	            i++;
	            nums[i] = nums[j];
	        }
	    }
	    return i + 1;
	}
}
