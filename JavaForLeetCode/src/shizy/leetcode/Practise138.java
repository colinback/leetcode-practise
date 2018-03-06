package shizy.leetcode;

/*
 * A linked list is given such that each node contains an additional random 
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 */

public class Practise138 {
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise138 p = new Practise138();
		
		// a random list
		RandomListNode r1 = p.new RandomListNode(1);
		RandomListNode r2 = p.new RandomListNode(2);
		RandomListNode r3 = p.new RandomListNode(3);
		RandomListNode r4 = p.new RandomListNode(4);
		RandomListNode r5 = p.new RandomListNode(5);
		r1.next = r2; r2.next = r3; r3.next = r4; r4.next = r5;
		r2.random = r5;
		r5.random = r1;
	}

	 public RandomListNode copyRandomList(RandomListNode head) {
		 RandomListNode iter = head;
		 // first loop
		 while(iter != null) {
			 RandomListNode next = iter.next;
			 RandomListNode copy = new RandomListNode(iter.label);
			 iter.next = copy;
			 copy.next = next;
			 iter = next;
		 }
		 
		 // second loop: assign random
		 iter = head;
		 while(iter != null) {
			 if (iter.random != null) {
				 iter.next.random = iter.random.next;
			 }
			 iter = iter.next.next;
		 }
		 
		 // thrid loop: retore original link
		 iter = head;
		 RandomListNode dummy = new RandomListNode(-1);
		 RandomListNode copyIter = dummy;
		 while(iter != null) {
			 RandomListNode next = iter.next.next;
			 
			 //extract copy
			 RandomListNode copy = iter.next;
			 copyIter.next = copy;
			 copyIter = copy;
			 
			 iter.next = next;
			 iter = next;
		 }
		 
		 return dummy.next;
	 }
}
