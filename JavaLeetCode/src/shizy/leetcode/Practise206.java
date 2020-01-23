package shizy.leetcode;

/*
 * Reverse a singly linked list.
 *
 * For example,
 *
 * Given linked list: 1->2->3->4
 * Reversed link list becomes 4->3->2->1.
 */

public class Practise206 {
  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public static void main(String[] args) {
    Practise206 p = new Practise206();

    ListNode t1 = p.makeList(new int[] {1, 2, 3, 4});
    t1 = p.reverseList(t1);
    p.print(t1);

    ListNode t2 = p.makeList(new int[] {1});
    t2 = p.reverseList(t2);
    p.print(t2);

    ListNode t3 = p.makeList(new int[] {});
    t3 = p.reverseList(t3);
    p.print(t3);
  }

  public ListNode reverseList(ListNode head) {
    if (head == null)
      return head;

    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
      // keep curr.next
      ListNode next = curr.next;

      // reverse link
      curr.next = prev;

      // move forward prev & curr
      prev = curr;
      curr = next;
    }
    return prev;
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
    ListNode ln = null;
    if (head != null) {
      System.out.print(head.val);
      ln = head.next;
    }

    while (ln != null) {
      System.out.print(" -> " + ln.val);
      ln = ln.next;
    }
    System.out.println();
  }
}
