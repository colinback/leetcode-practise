package shizy.leetcode;

/*
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes 
 * of the first two lists.
 */
public class Practise021 {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise021 p = new Practise021();
		
		p.print(p.mergeTwoLists(p.makeList(new int[] {}), p.makeList(new int[] {})));
		p.print(p.mergeTwoLists(p.makeList(new int[] {1}), p.makeList(new int[] {})));
		p.print(p.mergeTwoLists(p.makeList(new int[] {1, 3}), p.makeList(new int[] {2, 4})));
	}

	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 if (l1 == null && l2 != null) return mergeTwoLists(l2, l1);
		 if (l2 == null) return l1;
		 
		 ListNode head = null;
		 if (l1.val <= l2.val) {
			 head = new ListNode(l1.val);
			 head.next = mergeTwoLists(l1.next, l2);
		 } else {
			 head = new ListNode(l2.val);
			 head.next = mergeTwoLists(l1, l2.next);
		 }
		 
		 return head;
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
