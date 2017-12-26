package shizy.leetcode;

/*
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 * 
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 * 
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 * 
 * Example 4:
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class Practise035 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise035 p = new Practise035();
		System.out.println(p.searchInsert(new int[] {1,3,5,6}, 5));
		System.out.println(p.searchInsert(new int[] {1,3,5,6}, 2));
		System.out.println(p.searchInsert(new int[] {1,3,5,6}, 7));
		System.out.println(p.searchInsert(new int[] {1,3,5,6}, 0));
		System.out.println(p.searchInsert(new int[] {}, 5));
	}

	public int searchInsert(int[] nums, int target) {
        int pos = 0;
        while(pos < nums.length) {
        		if (target == nums[pos])
        			break;
        		else if (target > nums[pos])
        			pos++;
        		else
        			break;
        }
        return pos;
    }
}
