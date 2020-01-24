package shizy.leetcode;

import java.util.Stack;

public class POJ1363 {

  public static void main(String[] args) {
    POJ1363 p = new POJ1363();
    System.out.println(p.isStackOrder(new int[] {5, 4, 1, 2, 3}));
    System.out.println(p.isStackOrder(new int[] {2, 1, 5, 4, 3}));
  }

  public boolean isStackOrder(int[] nums) {
    Stack<Integer> st = new Stack<Integer>();
    int pos = 0;

    for (int i = 1; i <= nums.length; i++) {
      st.push(i);

      while (pos < nums.length && !st.isEmpty() && st.peek() == nums[pos]) {
        st.pop();
        pos++;
      }
    }

    return st.isEmpty();
  }
}
