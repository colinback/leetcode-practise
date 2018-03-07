package shizy.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * Median is the middle value in an ordered integer list. 
 * If the size of the list is even, there is no middle value. 
 * So the median is the mean of the two middle value.
 * 
 * Examples: 
 * [2,3,4] , the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 */

public class Practise295 {
	class MedianFinder {
		private PriorityQueue<Integer> minHeap = null;
		private PriorityQueue<Integer> maxHeap = null;
		
	    /** initialize your data structure here. */
	    public MedianFinder() {
	    		minHeap = new PriorityQueue<>(Collections.reverseOrder());
	    		maxHeap = new PriorityQueue<>();
	    }
	    
	    public void addNum(int num) {
	    		if (minHeap.size() == 0) {
	    			minHeap.offer(num);
	    			return;
	    		}
	    		
	        if (minHeap.size() == maxHeap.size()) {
	        		if (num < maxHeap.peek())
	        			minHeap.offer(num);
	        		else
	        			maxHeap.offer(num);
	        } else if (minHeap.size() > maxHeap.size()) {
	        		if (minHeap.peek() < num)
	        			maxHeap.offer(num);
	        		else {
	        			int m = minHeap.poll();
	        			minHeap.offer(num);
	        			maxHeap.offer(m);
	        		}
	        } else {
	        		if (maxHeap.peek() > num)
	        			minHeap.offer(num);
	        		else {
	        			int m = maxHeap.poll();
	        			minHeap.offer(m);
	        			maxHeap.offer(num);
	        		}
	        }
	    }
	    
	    public double findMedian() {
		    	if (minHeap.size() == maxHeap.size())
		    		return (minHeap.peek() + maxHeap.peek())/2.0;
		    	else if (minHeap.size() > maxHeap.size())
		    		return (double)minHeap.peek();
		    	else 
		    		return (double)maxHeap.peek();
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise295 p = new Practise295();
		
		MedianFinder obj = p.new MedianFinder();
		obj.addNum(4);
		obj.addNum(5);
		System.out.println("----");
		double param_2 = obj.findMedian();
		System.out.println(param_2);
		
		obj.addNum(9);
		System.out.println("----");
		double param_3 = obj.findMedian();
		System.out.println(param_3);
		
		obj.addNum(1);
		System.out.println("----");
		double param_4 = obj.findMedian();
		System.out.println(param_4);
	}
}
