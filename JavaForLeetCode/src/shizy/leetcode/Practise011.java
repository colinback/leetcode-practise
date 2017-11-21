package shizy.leetcode;
/*
 * Given n non-negative integers a1, a2, ..., an, where each represents 
 * a point at coordinate (i, ai). n vertical lines are drawn such that 
 * the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
 * which together with x-axis forms a container, such that the container 
 * contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 */
public class Practise011 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise011 p = new Practise011();
		
		System.out.println(p.maxArea(new int[] {1, 1}));
	}

    public int maxArea_bruteforce(int[] height) {
        int n = height.length;
        int max = 0;
        for(int i = 0; i < n; i++) {
        		for(int j = i + 1; j < n; j++) {
        			int area = (j-i) * Math.min(height[i], height[j]);
        			if (area > max)
        				max = area;
        		}
        }
        return max;
    }
    
    public int maxArea(int[] height) {
    		int n = height.length;
    		int max = 0;
    		int l = 0, r = n - 1;
    		
    		while(l < r) {
    			max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
    			if (height[l] < height[r])
    				l++;
    			else
    				r--;
    		}
    		return max;
    }
}
