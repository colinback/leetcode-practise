package shizy.leetcode;

/*
 * Merge k sorted linked lists and return it as one sorted list. 
 * Analyze and describe its complexity.
 */
public class Practise023 {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise023 p = new Practise023();
		
		p.print(p.mergeKLists(
				new ListNode[] {p.makeList(new int[] {1,3,5}), p.makeList(new int[] {2,4,6})}
				));
		p.print(p.mergeKLists(
				new ListNode[] {p.makeList(new int[] {1,3,5}), p.makeList(new int[] {2,4,8}), p.makeList(new int[] {7, 9})}
				));
		p.print(p.mergeKLists(
				new ListNode[] {p.makeList(new int[] {1,3,5}), p.makeList(new int[] {})}
				));
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) return null;
		if (lists.length == 1) return lists[0];
		if (lists.length == 2) return mergeTwoLists(lists[0], lists[1]);
		
		ListNode[] newLists = new ListNode[lists.length/2 + 1];
		int i = 0;
		for(i = 0; i < lists.length/2; i++) {
			newLists[i] = mergeTwoLists(lists[i*2], lists[i*2+1]);
		}
		
		if (i*2 == lists.length - 1)
			newLists[i] = lists[i*2];
		
		return mergeKLists(newLists);
     }
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
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
