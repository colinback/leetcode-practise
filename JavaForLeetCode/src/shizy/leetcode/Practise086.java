package shizy.leetcode;

/*
 * Given a linked list and a value x, partition it such that all nodes 
 * less than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in 
 * each of the two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */

public class Practise086 {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise086 p = new Practise086();
		ListNode l1 = p.makeList(new int[] {1,4,3,2,5,2});
		l1 = p.partition(l1, 3);
		p.print(l1);
		
		ListNode l2 = p.makeList(new int[] {4,1,3,2,5,2});
		l2 = p.partition(l2, 3);
		p.print(l2);
	}
	
	public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode slowCurr = dummy;
        ListNode fastPrev = dummy, fastCurr = head;
        
        while(fastCurr != null) {
        		// 1->4->3
        		if (fastCurr.val >= x) {
        			fastPrev = fastCurr;
        			fastCurr = fastCurr.next;
        		} else if (slowCurr.next == fastCurr) {
        			// 1->2->2
        			slowCurr = slowCurr.next;
        			fastPrev = fastCurr;
        			fastCurr = fastCurr.next;
        		} else {
        			// linking change 1->4->3->2
        			ListNode slowNext = slowCurr.next;
        			slowCurr.next = fastCurr;
        			slowCurr = fastCurr;
        			
        			ListNode fastNext = fastCurr.next;
        			fastCurr.next = slowNext;
        			fastPrev.next = fastNext;
        			fastCurr = fastNext;
        		}
        }
        return dummy.next;
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

	private void print(ListNode head) {
		ListNode ln = head;
		if (ln != null) {
			System.out.print(ln.val);
			ln = ln.next;
		}

		while (ln != null) {
			System.out.print(" -> " + ln.val);
			ln = ln.next;
		}
		System.out.println();
	}
}
