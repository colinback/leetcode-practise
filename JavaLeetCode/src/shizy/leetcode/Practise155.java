package shizy.leetcode;

/*
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */

public class Practise155 {
  class MinStack {
    private Node head;

    public void push(int x) {
      if (head == null)
        head = new Node(x, x);
      else
        head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() { head = head.next; }

    public int top() { return head.val; }

    public int getMin() { return head.min; }

    private class Node {
      int val;
      int min;
      Node next;

      private Node(int val, int min) { this(val, min, null); }

      private Node(int val, int min, Node next) {
        this.val = val;
        this.min = min;
        this.next = next;
      }
    }
  }

  public static void main(String[] args) {
    Practise155 p = new Practise155();

    MinStack obj = p.new MinStack();
    obj.push(4);
    obj.push(3);
    obj.push(6);

    int param_1 = obj.getMin();
    System.out.println(param_1);

    int param_2 = obj.top();
    System.out.println(param_2);

    obj.pop();
    int param_3 = obj.top();
    System.out.println(param_3);
  }
}
