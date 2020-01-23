package shizy.leetcode;

/*
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 *
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */

public class Practise092 {
  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }
  }

  public static void main(String[] args) {
    Practise092 p = new Practise092();

    ListNode t1 = p.makeList(new int[] {1, 2, 3, 4, 5});
    t1 = p.reverseBetween(t1, 2, 4);
    p.print(t1);

    ListNode t2 = p.makeList(new int[] {1, 2, 3, 4, 5});
    t2 = p.reverseBetween(t2, 2, 5);
    p.print(t2);

    ListNode t3 = p.makeList(new int[] {1, 2, 3, 4, 5});
    t3 = p.reverseBetween(t3, 1, 5);
    p.print(t3);

    ListNode t4 = p.makeList(new int[] {1, 2, 3, 4, 5});
    t4 = p.reverseBetween(t4, 1, 3);
    p.print(t4);
  }

  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null || n - m < 1)
      return head;

    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    ListNode prev = dummy;
    for (int i = 0; i < m - 1; i++)
      prev = prev.next;

	// remember start & end position
	// node m-1 > start; node m -> end
    ListNode start = prev;
    ListNode end = prev.next;

	// node m -> prev; node m+1 -> curr
    prev = prev.next;
    ListNode curr = prev.next;

    // reverse node between m and n
    for (int j = 0; j < n - m; j++) {
      ListNode tmp = curr.next;
      curr.next = prev;

      // forward
      prev = curr;
      curr = tmp;
    }

    start.next = prev;
    end.next = curr;

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
