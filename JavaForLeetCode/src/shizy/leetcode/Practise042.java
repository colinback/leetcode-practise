package shizy.leetcode;

import java.util.Arrays;

/*
 * Given n non-negative integers representing an elevation map where the width of 
 * each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class Practise042 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise042 p = new Practise042();
		System.out.println(p.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6
		System.out.println(p.trap(new int[] {0, 1, 0, 2})); //1
		System.out.println(p.trap(new int[] {0, 1, 0, 2, 1})); //1
		System.out.println(p.trap(new int[] {0, 1, 0, 2, 1, 0, 1})); // 2
		System.out.println(p.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3})); // 5
	}

/*
	// dynamic programming
	public int trap(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		
		int n = height.length;
		int ans = 0;
		
        int[] maxHeightLeft = new int[n];
        int[] maxHeightRight = new int[n];
        
        maxHeightLeft[0] = height[0];
        maxHeightRight[n-1] = height[n-1];
        
        // 计算从左边开始到i位置最大height
        for(int i = 1; i < n; i++) {
        		maxHeightLeft[i] = Math.max(maxHeightLeft[i-1], height[i]);
        }
        
        // 计算从右边开始到i位置最小height
        for(int i = n-2; i >= 0; i--) {
        		maxHeightRight[i] = Math.max(maxHeightRight[i+1], height[i]);
        }
        
        //i位置水量是 min(maxleft, maxRight) - height[i]
        for(int i = 0; i < n; i++) {
        		int minHeight = Math.min(maxHeightLeft[i], maxHeightRight[i]);
        		ans += minHeight - height[i];
        }
        
        return ans;
    }
*/
	
	// two pointer
	public int trap(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		
		int n = height.length;
		int left = 0, right = n - 1;
		int leftMax = 0, rightMax = 0;
		int ans = 0;
		
		while(left < right) {
			if (height[left] < height[right]) {
				if (height[left] >= leftMax)
					leftMax = height[left];
				else 
					ans += leftMax - height[left];
				
				left++;
			} else {
				if (height[right] >= rightMax) 
					rightMax = height[right];
				else 
					ans += rightMax - height[right];
				
				right--;
			}
		}
		
		return ans;
	}
}
