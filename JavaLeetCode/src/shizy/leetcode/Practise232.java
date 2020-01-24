package shizy.leetcode;

import java.util.Stack;

/*
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 *
 * Notes:
 * - You must use only standard operations of a stack -- which means only push
 * to top, peek/pop from top, size, and is empty operations are valid.
 * - Depending on your language, stack may not be supported natively.
 *   You may simulate a stack by using a list or deque (double-ended queue), as
 * long as you use only standard operations of a stack.
 * - You may assume that all operations are valid (for example, no pop or peek
 * operations will be called on an empty queue).
 */

public class Practise232 {
  class MyQueue {
    private Stack<Integer> s1 = null;
    private Stack<Integer> s2 = null;

    /** Initialize your data structure here. */
    public MyQueue() {
      s1 = new Stack<Integer>();
      s2 = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) { s1.add(x); }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
      if (s2.isEmpty()) {
        while (!s1.isEmpty()) {
          s2.push(s1.pop());
        }
      }
      return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
      if (s2.isEmpty()) {
        while (!s1.isEmpty()) {
          s2.push(s1.pop());
        }
      }
      return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() { return s1.isEmpty() && s2.isEmpty(); }
  }

  public static void main(String[] args) {
    Practise232 p = new Practise232();

    MyQueue obj = p.new MyQueue();
    obj.push(1);
    obj.push(2);
    int param_2 = obj.pop();
    System.out.println(param_2);
    int param_3 = obj.peek();
    System.out.println(param_3);
    boolean param_4 = obj.empty();
    System.out.println(param_4);
  }
}
