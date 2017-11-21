package shizy.leetcode;

/*
 * Given a linked list, reverse the nodes of a linked list k at a time and 
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked list. 
 * If the number of nodes is not a multiple of k then left-out nodes in the end should 
 * remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * 
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */
public class Practise025 {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise025 p = new Practise025();
//		p.print(p.reverseKGroup(p.makeList(new int[] {1, 2, 3, 4, 5}), 1));
//		p.print(p.reverseKGroup(p.makeList(new int[] {1, 2, 3, 4, 5}), 2));
//		p.print(p.reverseKGroup(p.makeList(new int[] {1, 2, 3, 4, 5}), 3));
//		p.print(p.reverseKGroup(p.makeList(new int[] {1, 2, 3, 4}), 3));
//		p.print(p.reverseKGroup(p.makeList(new int[] {1, 2, 3}), 3));
		
		p.print(p.reverseKGroup_recursive(p.makeList(new int[] {1, 2, 3, 4, 5}), 3));
	}

    public ListNode reverseKGroup(ListNode head, int k) {
    		if(k == 1) return head;

    		ListNode dummy = new ListNode(-1);
    		dummy.next = head;
    		ListNode slow = dummy, fast = dummy;
    		int i = 0;
    		
    		while(slow == fast) {
	    		for(i = 0; i < k; i++) {
	    			if (fast == null)
	    				break;
	    			fast = fast.next;
	    		}
	    		
	    		if (i == k && fast != null) {
	    			fast = reverse(slow, fast);
	    			slow = fast;
	    		}
    		}
    	
    		return dummy.next;
    }
    
    private ListNode reverse(ListNode begin, ListNode end){
	    	ListNode curr = begin.next;
	    	ListNode first = curr;
	    	ListNode prev = begin;
	    
	    	ListNode next;
	    	while (prev != end){
	    		next = curr.next;
	    		curr.next = prev;
	    		prev = curr;
	    		curr = next;
	    	}
	    	
	    	begin.next = prev;
	    	first.next = curr;
	    	return first;
    }
    
    public ListNode reverseKGroup_recursive(ListNode head, int k) {
    		ListNode curr = head;
    		int count = 0;
    		while (curr !=null && count != k ) {
    			curr = curr.next;
    			count++;
    		}
    		
    		if (count == k) {
    			curr = reverseKGroup_recursive(curr, k);
    			
    			while(count-- > 0) {
    				ListNode tmp = head.next;
    				head.next = curr;
    				curr = head;
    				head = tmp;
    			}
    			head = curr;
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
