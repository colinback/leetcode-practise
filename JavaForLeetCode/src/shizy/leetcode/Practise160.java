package shizy.leetcode;

/*
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * For example, the following two linked lists:
 * 
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗            
 * B:     b1 → b2 → b3
 * 
 * begin to intersect at node c1.
 * 
 * Notes:
 * 	- If the two linked lists have no intersection at all, return null.
 * 	- The linked lists must retain their original structure after the function returns.
 *  - You may assume there are no cycles anywhere in the entire linked structure.
 *  - Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class Practise160 {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		Practise160 p = new Practise160();
		ListNode t1 = p.makeList(new int[] {6, 7, 8});
		
		ListNode t1a = p.new ListNode(1);
		t1a.next = p.new ListNode(2);
		// t1a.next.next = t1;
		
		ListNode t1b = p.new ListNode(3);
		t1b.next = p.new ListNode(4);
		t1b.next.next = p.new ListNode(5);
		// t1b.next.next.next = t1;
		
		
		ListNode intersect = p.getIntersectionNode(t1a, t1b);
		System.out.println(intersect);
	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		
		ListNode currA = headA;
		ListNode currB = headB;
		
		while(currA != currB) {
			currA = currA == null ? headB: currA.next;
			currB = currB == null ? headA: currB.next;
		}
		
		return currA;
    }

	private ListNode makeList(int[] arr) {
		if (arr.length == 0)
			return null;
		ListNode head = null;
		ListNode curr = null;

		for (int i : arr) {
			ListNode ln = new ListNode(i);
			if (curr == null)
				head = ln;
			else
				curr.next = ln;

			curr = ln;
		}
		return head;
	}
}
