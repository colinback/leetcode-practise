package shizy.leetcode;

import shizy.leetcode.Practise023.ListNode;

/*
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values in the list, 
 * only nodes itself can be changed.
 */
public class Practise024 {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise024 p = new Practise024();
		p.print(p.swapPairs(p.makeList(new int[] {1, 2, 3, 4})));
		p.print(p.swapPairs(p.makeList(new int[] {1, 3})));
		p.print(p.swapPairs(p.makeList(new int[] {1})));
		p.print(p.swapPairs(p.makeList(new int[] {})));
	}

	public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode swapNode;
        ListNode first = dummy, second = head;
        
        while(first.next != null && second.next != null) {
        		swapNode = second.next;
        		first.next = swapNode;
        		second.next = swapNode.next;
        		swapNode.next = second;
        		
        		// update first & second
        		first = second;
        		second = second.next;
        }
        
        return dummy.next;
    }
	
	private ListNode makeList(int[] arr) {
		if (arr.length == 0) return null;
		ListNode head = null;
		ListNode curr = null;
		
		for(int i: arr) {
			ListNode ln = new ListNode(i);
			if (curr == null)
				head = ln;
			else 
				curr.next = ln;
				
			curr = ln;
		}
		return head;
	}

	private void print(ListNode head) {
			ListNode ln = head;
			if (ln != null) {
				System.out.print(ln.val);
				ln = ln.next;
			}
			
			while(ln != null) {
				System.out.print(" -> " + ln.val);
				ln = ln.next;
			}
			System.out.println();
	}
}
