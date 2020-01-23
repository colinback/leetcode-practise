package shizy.leetcode;

/*
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 *
 * 	a1 → a2 → a3 → a4
 * 		    ↗		 ↘
 * 		  a7 <- a6 <- a5
 *
 * Note: Do not modify the linked list.
 */

public class Practise142 {
  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public static void main(String[] args) {
    Practise142 p = new Practise142();

    ListNode list = p.new ListNode(1);
    list.next = p.new ListNode(2);
    ListNode circle = p.makeCircle(new int[] {3, 4, 6, 7});
    list.next.next = circle;

    ListNode start = p.detectCycle(list);
    System.out.println(start.val);
  }

  public ListNode detectCycle(ListNode head) {
    if (head == null)
      return null;

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      // has cycle
      if (fast == slow) {
        slow = head;
        while (slow != fast) {
          slow = slow.next;
          fast = fast.next;
        }
        return slow;
      }
    }

    return null;
  }

  private ListNode makeCircle(int[] arr) {
    if (arr.length == 0)
      return null;
    ListNode head = null;
    ListNode curr = null;

    for (int i = 0; i < arr.length; i++) {
      ListNode ln = new ListNode(arr[i]);
      if (curr == null)
        head = ln;
      else
        curr.next = ln;

      curr = ln;

      if (i == arr.length - 1)
        curr.next = head;
    }
    return head;
  }
}
