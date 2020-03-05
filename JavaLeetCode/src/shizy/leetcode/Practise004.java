package shizy.leetcode;

import java.util.Arrays;

/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
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
		Practise004 p = new Practise004();

		System.out.println(p.findMedianSortedArrays(new int[] { 2 }, new int[] {}));
		System.out.println(p.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
		System.out.println(p.findMedianSortedArrays(new int[] { 1 }, new int[] { 2, 3 }));
		System.out.println(p.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
		System.out.println(p.findMedianSortedArrays(new int[] { 1, 4 }, new int[] { 2, 5 }));
		System.out.println(p.findMedianSortedArrays(new int[] { 1, 4, 9, 11 }, new int[] { 2, 5, 7, 8 }));
		System.out.println(p.findMedianSortedArrays(new int[] { 3 }, new int[] { -2, -1 }));
	}

	// by find kth smallest value
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;

		if ((m + n) % 2 == 1)
			return getKth(nums1, nums2, (m + n + 1) / 2);
		else
			return (getKth(nums1, nums2, (m + n + 1) / 2) + getKth(nums1, nums2, (m + n + 2) / 2)) / 2.0;
	}

	private int getKth(int[] nums1, int[] nums2, int k) {
		int m = nums1.length;
		int n = nums2.length;

		assert (!(m == 0 && n == 0));

		if (m == 0)
			return nums2[k - 1];

		if (n == 0)
			return nums1[k - 1];

		if (k == 1)
			return Math.min(nums1[0], nums2[0]);

		// nums1: 0, ..., i-1, i, ..., m-1 (i = k/2) 
		// nums2: 0, ..., j-1, j, ..., n-1 (j = k/2) 
		// or: 
		// nums1: 0, ..., i-1 (i = m) 
		// nums2: 0, ..., j-1, j, ..., n (j = k/2)
		// or: 
		// nums1: 0, ..., i-1, i, ..., m-1 (i = k/2) 
		// nums2: 0, ..., j-1 (j = n)

		int i = Math.min(m, k / 2);
		int j = Math.min(n, k / 2);

		if (nums2[j - 1] < nums1[i - 1]) {
			// throw nums2[0, ..., j-1]
			return getKth(nums1, Arrays.copyOfRange(nums2, j, n), k - j);
		} else {
			// throw nums1[0, ..., i-1]
			return getKth(Arrays.copyOfRange(nums1, i, m), nums2, k - i);
		}
	}

	// better understanding
	/*
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;

		// ensure len(nums1) <= len(nums2)
		if (m > n)
			return findMedianSortedArrays(nums2, nums1);

		// nums1: 0, ..., i - 1, i, ..., m - 1
		// nums2: 0, ..., j - 1, j, ..., n - 1
		int lo = 0, hi = m;

		// it's really difficult to deal with loop condition and edge values. For
		// example, if we define: 
		//		nums1: 0, ..., i, i + 1, ..., m - 1 
		// 		nums2: 0, ..., j, j + 1, ..., n - 1
		// it's not that easy to handle the loop

		while (lo <= hi) {
			int i = (lo + hi) / 2; // mid
			int j = (m + n + 1) / 2 - i;

			if (i > 0 && j < n && nums1[i - 1] > nums2[j]) // i is too large
				hi = i - 1;
			else if (j > 0 && i < m && nums2[j - 1] > nums1[i]) // i is too small
				lo = i + 1;
			else { // i is perfect
				int maxLeft = 0, maxRight = 0;

				// calculate maxLeft
				if (i == 0)
					maxLeft = nums2[j - 1];
				else if (j == 0)
					maxLeft = nums1[i - 1];
				else
					maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);

				// odd case
				if ((m + n) % 2 == 1)
					return maxLeft;

				// calculate rightLeft
				if (i == m)
					maxRight = nums2[j];
				else if (j == n)
					maxRight = nums1[i];
				else
					maxRight = Math.min(nums1[i], nums2[j]);

				// even case
				return (maxLeft + maxRight) / 2.0;
			}
		}

		return 0.0;
	}
	*/

	// another bineary search version, still difficult to handle loop
	/*
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;

		// make sure m <= n
		if (m > n)
			return findMedianSortedArrays(nums2, nums1);

		//        lo                 hi = (m+n)/2 
		// nums1: 0, ..., midM, ..., i, ..., m-1 
		// nums2: 0, ..., midN, ..., ..., ..., ..., n-1
		// or 
		//        lo                      hi = m 
		// nums1: 0, ..., midM, ..., m-1 (m) 
		// nums2: 0, ..., midN, ..., ..., ..., ..., n-1

		int k = (m + n - 1) / 2;
		int lo = 0, hi = Math.min(m, k);

		while (lo < hi) {
			int midM = (lo + hi) / 2;
			int midN = k - midM;

			if (nums1[midM] < nums2[midN])
				lo = midM + 1;
			else
				hi = midM;
		}

		// after binary search, we get these 4 numbers:
		// nums1[lo-1], nums1[lo], nums2[k-lo], and nums2[k-lo+1]

		// if (n+m) is odd, the median is the larger one between nums1[lo-1] and
		// nums2[k-lo].
		int a = Math.max(lo > 0 ? nums1[lo - 1] : Integer.MIN_VALUE, k - lo >= 0 ? nums2[k - lo] : Integer.MIN_VALUE);
		if ((m + n) % 2 == 1)
			return (double) a;

		// if (n+m) is even, the median can be calculated by
		// median = (max(nums1[lo-1], nums2[k-lo]) + min(nums1[lo], nums2[k-lo+1]) / 2.0
		int b = Math.min(lo < m ? nums1[lo] : Integer.MAX_VALUE,
				k - lo + 1 < n ? nums2[k - lo + 1] : Integer.MAX_VALUE);
		return (a + b) / 2.0;
	}
	*/
}
