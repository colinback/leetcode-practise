package shizy.leetcode;

/*
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
class ListNode {
	int val;
	ListNode next = null;
	ListNode(int x) { val = x;}
}

public class Practise002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise002 p = new Practise002();
		
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode addResult1 = p.addTowNumbers(l1, l2);
		p.printListNode(addResult1);
		
		ListNode l3 = new ListNode(9);
		l3.next = new ListNode(9);
		
		ListNode l4 = new ListNode(1);
		
		ListNode addResult2 = p.addTowNumbers(l3, l4);
		p.printListNode(addResult2);
	}
	
	private void printListNode(ListNode ln) {
		while(ln != null) {
			System.out.print(ln.val + " ");
			ln = ln.next;
		}
		System.out.println();
	}

	public ListNode addTowNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
	    ListNode curr = dummyHead;
	    int carry = 0;
	    
	    while (l1 != null || l2 != null) {
	    		// when l1 or l2 is null
	        int x = (l1 != null) ? l1.val : 0;
	        int y = (l2 != null) ? l2.val : 0;
	        
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        
	        if (l1 != null) l1 = l1.next;
	        if (l2 != null) l2 = l2.next;
	    }
	    
	    // remember to deal with the carry
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    
	    // use dummyHead and return dummyHead.next
	    return dummyHead.next;
	}
}
