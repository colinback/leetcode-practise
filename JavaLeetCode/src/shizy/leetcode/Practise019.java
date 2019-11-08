package shizy.leetcode;

/*
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class Practise019 {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise019 p = new Practise019();
		
		ListNode t1 = p.makeList(new int[] {1});
		p.print(t1);
		p.print(p.removeNthFromEnd(t1, 1));
//		ListNode head = p.new ListNode(1);
//		p.print(head);
//		
//		p.print(p.removeNthFromEnd(head, 1));
		
		ListNode t2 = p.makeList(new int[] {1, 2});
		p.print(t2);
		p.print(p.removeNthFromEnd(t2, 0));
		
		ListNode t3 = p.makeList(new int[] {1, 2});
		p.print(t3);
		p.print(p.removeNthFromEnd(t3, 1));
		
		ListNode t4 = p.makeList(new int[] {1, 2});
		p.print(t4);
		p.print(p.removeNthFromEnd(t4, 2));
		
		ListNode t5 = p.makeList(new int[] {1, 2, 3, 4, 5});
		p.print(t5);
		p.print(p.removeNthFromEnd(t5, 2));
		
		ListNode t6 = p.makeList(new int[] {1, 2});
		p.print(t6);
		p.print(p.removeNthFromEnd(t2, 3));
	}

    public ListNode removeNthFromEnd(ListNode head, int n) {
    		if (n <= 0) return head;
    		
    		// prev  -> nth -> ... -> tail -> null
        ListNode curr = head;
        ListNode pre = head;
        int count = n;
        
        while(curr != null) {
    			if (count < 0) {
    				pre = pre.next;
    			}
    			
    			count--;
    			curr = curr.next;
        }
        
        if (count == 0)
        		return head.next;
        
        //remove nth
        if (pre != null)
        		pre.next = (pre.next == null) ? null: pre.next.next;
        
        return head;
    }
	
//	public ListNode removeNthFromEnd(ListNode head, int n) {
//		if (n <= 0) return head;
//		
//		// 学习dummy的方法
//		ListNode start = new ListNode(0);
//		ListNode slow = start, fast = start;
//		
//		slow.next = head;
//		int i;
//		
//		// 第一步：先设置slow, fast,中间间隔n个节点
//		for(i = 0; i <= n; i++) {
//			if (fast == null) 
//				break;
//	
//			fast = fast.next;
//		}
//		
//		//  第二步：移动窗口到末尾
//		while(fast != null) {
//			slow = slow.next;
//			fast = fast.next;
//		}
//		
//		//注意n大于List长度的情况
//		if (i > n)
//			slow.next = slow.next.next;
//		
//		return start.next;
//	}
    
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