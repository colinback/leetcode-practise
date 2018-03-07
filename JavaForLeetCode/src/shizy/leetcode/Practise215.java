package shizy.leetcode;

import java.util.PriorityQueue;

/*
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element 
 * in the sorted order, not the kth distinct element.
 * 
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

public class Practise215 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise215 p = new Practise215();

		int[] nums = new int[] { 3, 2, 1, 5, 6, 4 };
		int kth = p.findKthLargest(nums, 2);
		System.out.println(kth);
	}

	/* quickSort idea */
	public int findKthLargest(int[] a, int k) {
		int n = a.length;
		int p = quickSelect(a, 0, n - 1, n - k + 1);
		return a[p];
	}

	// return the index of the kth smallest number
	int quickSelect(int[] a, int lo, int hi, int k) {
		// use quick sort's idea
		// put nums that are <= pivot to the left
		// put nums that are > pivot to the right
		int i = lo, j = hi, pivot = a[hi];
		while (i < j) {
			if (a[i++] > pivot)
				swap(a, --i, --j);
		}
		swap(a, i, hi);

		// count the nums that are <= pivot from lo
		int m = i - lo + 1;

		// pivot is the one!
		if (m == k)
			return i;
		// pivot is too big, so it must be on the left
		else if (m > k)
			return quickSelect(a, lo, i - 1, k);
		// pivot is too small, so it must be on the right
		else
			return quickSelect(a, i + 1, hi, k - m);
	}

	void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public int findKthLargest_PriorityQueue(int[] nums, int k) {
		// 最小堆 min oriented priority queue
		final PriorityQueue<Integer> pq = new PriorityQueue<>();
	    for(int val : nums) {
	        pq.offer(val);

	        if(pq.size() > k) {
	            pq.poll();
	        }
	    }
	    return pq.peek();
	}
}
