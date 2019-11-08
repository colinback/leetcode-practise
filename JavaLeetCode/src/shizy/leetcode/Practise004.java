package shizy.leetcode;

/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * 
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class Practise004 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise004 p = new Practise004();
		
		System.out.println(p.findMedianSortedArrays_bruteforce(new int[]{2}, new int[]{}));
		System.out.println(p.findMedianSortedArrays_bruteforce(new int[]{1, 3}, new int[]{2}));
		System.out.println(p.findMedianSortedArrays_bruteforce(new int[]{1}, new int[]{2, 3}));
		System.out.println(p.findMedianSortedArrays_bruteforce(new int[]{1, 2}, new int[]{3, 4}));
		System.out.println(p.findMedianSortedArrays_bruteforce(new int[]{1, 4}, new int[]{2, 5}));
		System.out.println(p.findMedianSortedArrays_bruteforce(new int[]{1, 4, 9, 11}, new int[]{2, 5, 7, 8}));
		
		System.out.println(p.findMedianSortedArrays_recursive(new int[]{2}, new int[]{}));
		System.out.println(p.findMedianSortedArrays_recursive(new int[]{1, 3}, new int[]{2}));
		System.out.println(p.findMedianSortedArrays_recursive(new int[]{1}, new int[]{2, 3}));
		System.out.println(p.findMedianSortedArrays_recursive(new int[]{1, 2}, new int[]{3, 4}));
		System.out.println(p.findMedianSortedArrays_recursive(new int[]{1, 4}, new int[]{2, 5}));
		System.out.println(p.findMedianSortedArrays_recursive(new int[]{1, 4, 9, 11}, new int[]{2, 5, 7, 8}));
	}
	
	// run time complexity O((m+n)/2)
	public double findMedianSortedArrays_recursive(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int left = (m + n + 1) /2;
		int right = (m + n + 2) /2;
		return (getkth(nums1, 0, nums2, 0, left) + getkth(nums1, 0, nums2, 0, right)) / 2.0;
	}
	
	private double getkth(int[] nums1, int lStart, int[] nums2, int rStart, int k) {
		if (lStart > nums1.length - 1) return nums2[rStart + k - 1];
		if (rStart > nums2.length - 1) return nums1[lStart + k - 1];
		if (k == 1) return Math.min(nums1[lStart], nums2[rStart]);
		
		int lMid = Integer.MAX_VALUE;
		int rMid = Integer.MAX_VALUE;
		if (lStart + k/2 -1 < nums1.length)
			lMid = nums1[lStart + k/2 -1];
		if (rStart + k/2 -1 < nums2.length)
			rMid = nums2[rStart + k/2 -1];
		
		if (lMid < rMid) 
			return getkth(nums1, lStart + k/2, nums2, rStart, k - k/2); 
		else 
			return getkth(nums1, lStart, nums2, rStart + k/2, k - k/2);
	}
	
	public double findMedianSortedArrays_bruteforce(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int medianNum = (m + n) /2 + 1;
		int i = 0, j = 0, curr = 0;
		int[] median = new int[medianNum];
		
		while(curr < medianNum) {
			if (j >= n && i < m) {
				median[curr] = nums1[i];
				i++;
			}
			
			if (i >= m && j < n) {
				median[curr] = nums2[j];
				j++;
			}
			
			if (i < m && j < n) {
				if(nums1[i] < nums2[j]) {
					median[curr] = nums1[i];
					i++;
				} else {
					median[curr] = nums2[j];
					j++;
				}
			}
							
			curr++;
		}
		
		if ((m + n) % 2 == 0) {
			return (median[medianNum - 2] + median[medianNum - 1]) / 2.0;
		} else {
			return median[medianNum -1];
		}
	}
}
