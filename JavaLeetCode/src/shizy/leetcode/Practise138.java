package shizy.leetcode;

/*
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * Example 1
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * Example 2
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 *
 * Example 3
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 */

public class Practise138 {
  class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  public static void main(String[] args) {
    Practise138 p = new Practise138();

    // a random list
    Node r1 = p.new Node(1);
    Node r2 = p.new Node(2);
    Node r3 = p.new Node(3);
    Node r4 = p.new Node(4);
    Node r5 = p.new Node(5);
    r1.next = r2;
    r2.next = r3;
    r3.next = r4;
    r4.next = r5;
    r2.random = r5;
    r5.random = r1;

    Node dc = p.copyRandomList(r1);
    System.out.println(dc.next.random.val); // should be 5
  }

  public Node copyRandomList(Node head) {
    Node iter = head;
    // first loop: A -> A' -> B -> B' -> C -> C'
    while (iter != null) {
      Node next = iter.next;
      Node copy = new Node(iter.val);
      iter.next = copy;
      copy.next = next;
      iter = next;
    }

    // second loop: assign random
    iter = head;
    while (iter != null) {
      if (iter.random != null) {
        iter.next.random = iter.random.next;
      }
      iter = iter.next.next;
    }

    // thrid loop: retore original link
    iter = head;
    Node dummy = new Node(-1);
    Node copyIter = dummy;
    while (iter != null) {
      Node next = iter.next.next;

      // extract copy
      Node copy = iter.next;
      copyIter.next = copy;
      copyIter = copy;

      iter.next = next;
      iter = next;
    }

    return dummy.next;
  }
}
