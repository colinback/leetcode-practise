package shizy.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example:
 * Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. 
 * (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * 
 * Note:
 * You can assume that you can always reach the last index.
 */
public class Practise045 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise045 p = new Practise045();
		System.out.println(p.jump(new int[] {2, 3, 1, 1, 4}));
		System.out.println(p.jump(new int[] {2, 2, 3, 1, 4, 1, 2, 1}));
		System.out.println(p.jump(new int[] {0}));	
		System.out.println(p.jump(new int[] {2, 1}));
		System.out.println(p.jump(new int[] {1, 2}));
		
		System.out.println(p.jump(new int[] {3,2,1,0,4}));
	}
	
	public int jump(int[] nums) {
		if (nums.length <= 0) return 0;
	    
	    int count = 0;
	    int lo = 0;
	    int hi = 0;
	    int fast = 0;
	            
	    while(fast < nums.length - 1) {
	    		for(int i = lo; i <= Math.min(hi, nums.length-1); i++) {
	    			if (i + nums[i] > fast) {
	    				fast = i + nums[i];
	    			}
	    		}
	    		
	    		count++;
	    		lo = hi + 1;
	    		hi = fast;
	    }
	    
	    return count;
	}
	
	/*
	public int jump(int[] nums) {
        if (nums.length <= 0) return 0;
                
        int steps = 0;
        int pos = 0;
        int max = 0;
        
        for(int i = 0; i < nums.length - 1; i++) {
        		max = Math.max(max, i + nums[i]);
        		
        		if(pos == i) {
        			steps++;
        			pos = max;
        		}
        }
        
        if (max < nums.length - 1)
        		return -1;
        
        return steps;
    }
	*/
}
