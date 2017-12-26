package shizy.leetcode;

/*
 * Suppose an array sorted in ascending order is rotated at some pivot 
 * unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return 
 * its index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 */
public class Practise033 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise033 p = new Practise033();
		System.out.println(p.search(new int[] {4,5,6,0,1,2}, 6));
		System.out.println(p.search(new int[] {4,5,6,0,1,2,3}, 3));
		System.out.println(p.search(new int[] {4,5,6,7,0,1,2}, 0));
		System.out.println(p.search(new int[] {1,2}, 6));
		System.out.println(p.search(new int[] {1,2}, 1));
		System.out.println(p.search(new int[] {2,1}, 1));
		System.out.println(p.search(new int[] {2}, 2));
		System.out.println(p.search(new int[] {4,5,6,7,0,1,2}, 5));		
		System.out.println(p.search(new int[] {5, 1, 3}, 5));
		System.out.println(p.search(new int[] {4, 5, 6, 7, 8, 1, 2, 3}, 8));
	}

    public int search(int[] nums, int target) {
        // if (nums.length <= 0) return -1;
        
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
        		int mid = (lo + hi) / 2;
        		//System.out.println(lo + " " + mid + " " + hi);
        		
        		if (nums[mid] == target)
        			return mid;
        		
        		if (nums[mid] > target) {
        			if (nums[lo] > target && nums[lo] <= nums[mid])
        				lo = mid + 1;
        			else
        				hi = mid -1;
        		} else {
        			if (nums[hi] < target && nums[mid] <= nums[hi])
        				hi = mid - 1;			
        			else
        				lo = mid + 1;
        		}
        }
        
        return -1;
    }
}
