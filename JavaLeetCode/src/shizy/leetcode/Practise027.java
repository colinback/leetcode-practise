package shizy.leetcode;

import java.util.Arrays;

/*
 * Given an array and a value, remove all instances of that value in-place and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying the input array 
 * in-place with O(1) extra memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * Example:
 * 
 * Given nums = [3,2,2,3], val = 3,
 * 
 * Your function should return length = 2, with the first two elements of nums being 2.
 */
public class Practise027 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise027 p = new Practise027();
		
		int[] input1 = new int[] {3, 2, 2, 3};
		System.out.println(p.removeElement(input1, 3));
		System.out.println(Arrays.toString(input1));
		
		int[] input2 = new int[] {1};
		System.out.println(p.removeElement(input2, 1));
		System.out.println(Arrays.toString(input2));
		
		int[] input3 = new int[] {4, 5};
		System.out.println(p.removeElement(input3, 5));
		System.out.println(Arrays.toString(input3));
	}

//	public int removeElement(int[] nums, int val) {
//		if (nums.length == 0) return 0;
//		
//        int i = nums.length;
//        for(int j = 0; j < i ; j++) {
//        		if (nums[j] == val) {
//        			while(i > j && nums[--i] == val);
//    				nums[j] = nums[i];
//        		}
//        }
//        return i;
//    }
	
	public int removeElement(int[] nums, int val) {
		int i = 0;
		for(int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}
}
