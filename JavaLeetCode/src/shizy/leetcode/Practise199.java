package shizy.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

/*
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */

public class Practise199 {
  class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    Practise199 p = new Practise199();

    // TreeNode root = p.makeTree(new int[] {}, 0);
    TreeNode root = p.makeTree(new int[] { 1, 2, 3, -1, 5, -1, 4 }, 0);
    // TreeNode root = p.makeTree(new int[] {1, 2, 3, 4}, 0);

    System.out.println(p.rightSideView(root));
  }

  // BFS
  /*
  public List<Integer> rightSideView(TreeNode root) {
    if (root == null)
      return new ArrayList<>();

    List<Integer> output = new ArrayList<>();

    rightSideViewHelper(new ArrayList<TreeNode>() {
      {
        add(root);
      }
    }, output);

    return output;
  }

  private void rightSideViewHelper(List<TreeNode> nodes, List<Integer> output) {
    if (nodes.size() == 0)
      return;

    output.add(nodes.get(nodes.size() - 1).val);

    // next layer nodes
    List<TreeNode> children = new ArrayList<>();
    for (TreeNode tn : nodes) {
      if (tn.left != null)
        children.add(tn.left);

      if (tn.right != null)
        children.add(tn.right);
    }

    rightSideViewHelper(children, output);
  }
  */

  // DFS
  public List<Integer> rightSideView(TreeNode root) {
    Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
    int max_depth = -1;

    /*
     * These two stacks are always synchronized, providing an implicit association
     * values with the same offset on each Queue.
     */
    Stack<TreeNode> nodeStack = new Stack<TreeNode>();
    Stack<Integer> depthStack = new Stack<Integer>();
    nodeStack.push(root);
    depthStack.push(0);

    while (!nodeStack.isEmpty()) {
      TreeNode node = nodeStack.pop();
      int depth = depthStack.pop();

      if (node != null) {
        max_depth = Math.max(max_depth, depth);

        if (!rightmostValueAtDepth.containsKey(depth))
          rightmostValueAtDepth.put(depth, node.val);

        nodeStack.push(node.left);
        nodeStack.push(node.right);
        depthStack.push(depth + 1);
        depthStack.push(depth + 1);
      }
    }

    /*
     * Construct the solution based on the values that we end up with at the end.
     */
    List<Integer> rightView = new ArrayList<Integer>();
    for (int depth = 0; depth <= max_depth; depth++) {
      rightView.add(rightmostValueAtDepth.get(depth));
    }

    return rightView;
  }

  public TreeNode makeTree(int[] nums, int idx) {
    TreeNode root = null;

    if (nums[idx] >= 0) {
      root = new TreeNode(nums[idx]);

      // left
      if (2 * idx + 1 < nums.length)
        root.left = makeTree(nums, 2 * idx + 1);

      // right
      if (2 * idx + 2 < nums.length)
        root.right = makeTree(nums, 2 * idx + 2);
    }

    return root;
  }
}
