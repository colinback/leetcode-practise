package shizy.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Implement the following operations of a stack using queues.
 * average O(1) time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * 
 * Notes:
 * - You must use only standard operations of a queue -- which means only push to back, 
 *   peek/pop from front, size, and is empty operations are valid.
 * - Depending on your language, queue may not be supported natively. You may simulate 
 *   a queue by using a list or deque (double-ended queue), as long as you use only 
 *   standard operations of a queue.
 * - You may assume that all operations are valid (for example, no pop or top 
 *   operations will be called on an empty stack).
 */

public class Practise225 {
	class MyStack {
		private Queue<Integer> q = null;
		
	    /** Initialize your data structure here. */
	    public MyStack() {
	        q = new LinkedList<Integer>();
	    }
	    
	    /** Push element x onto stack. */
	    public void push(int x) {
	    		Queue<Integer> nq = new LinkedList<Integer>();
	    		nq.add(x);
	    		nq.addAll(q);
	    		
	    		q = nq;
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
	        return q.poll();
	    }
	    
	    /** Get the top element. */
	    public int top() {
	        return q.peek();
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
	        return q.isEmpty();
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Practise225 p = new Practise225();
		
		 MyStack obj = p.new MyStack();
		 obj.push(5);
		 obj.push(2);
		 int param_2 = obj.pop();
		 System.out.println(param_2);
		 int param_3 = obj.top();
		 System.out.println(param_3);
		 boolean param_4 = obj.empty();
		 System.out.println(param_4);
	}

}
