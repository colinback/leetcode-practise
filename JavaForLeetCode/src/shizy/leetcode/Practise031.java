package shizy.leetcode;

import java.util.Arrays;
import java.util.Collections;

/*
 * Implement next permutation, which rearranges numbers into the lexicographically 
 * next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest possible 
 * order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding 
 * outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Practise031 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise031 p = new Practise031();
		
//		int[] input1 = new int[] {3,2,1};
//		p.nextPermutation(input1);
//		System.out.println(Arrays.toString(input1));
//		
//		int[] input2 = new int[] {1,2,3};
//		p.nextPermutation(input2);
//		System.out.println(Arrays.toString(input2));
//		
//		int[] input3 = new int[] {1,1,5};
//		p.nextPermutation(input3);
//		System.out.println(Arrays.toString(input3));
		
		int[] input4 = new int[] {1,3,2};
		p.nextPermutation(input4);
		System.out.println(Arrays.toString(input4));
	}
	
	public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        
        // 从最右边开始扫描，找到第一个nums[i-1] < nums[i]
        int i = nums.length - 1;
        while(i > 0 && nums[i-1] >= nums[i])
        		i--;
        
        // 如果已经是最左边了，排序返回
        if (i == 0) {
        		Arrays.sort(nums);
        		return;
        } 
        
        // 从i位置开始扫描后面的数字，找到比i-1大的最小值
        int j = i + 1;
        int min = nums[i];
        int pos = i;
        for(; j < nums.length; j++) {
        		if (nums[j] > nums[i-1] && nums[j] < min) {
        			pos = j;
        			min = nums[j];
        		}
        }
        
        //交换i-1和pos的数字
        int tmp = nums[i-1];
        	nums[i-1] = nums[pos];
        	nums[pos] = tmp;
        	
        	//对[i...nums.length-1]排序
        	Arrays.sort(nums, i, nums.length);
    }

}
