package shizy.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

/*
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * 
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 
 *         3
 *      /     \
 *     5       1
 *    / \     / \
 *   6   2   0   8
 *     / \ 
 *    7   4
 * 
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * 
 * Example 2:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of
 * itself according to the LCA definition.

 */

public class Practise236 {
  public class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    Practise236 p = new Practise236();

    TreeNode root = p.makeTree(new int[] { 3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4 }, 0);

    TreeNode l = root.left; // TreeNode 5
    // TreeNode r = root.right; // TreeNode 1
    TreeNode r = root.left.right.right; // TreeNode 4
    System.out.println(p.lowestCommonAncestor(root, l, r).val);
  }

  // Recusion
  /*
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> lowestCommon = new ArrayList<>();
    recurseTree(root, p, q, lowestCommon);
    return lowestCommon.get(0);
  }

  private boolean recurseTree(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> lc) {
    if (root == null)
      return false;

    // left recusion
    int left = recurseTree(root.left, p, q, lc) ? 1 : 0;
    // right recusion
    int right = recurseTree(root.right, p, q, lc) ? 1 : 0;
    // current node is either p or q
    int curr = (root == p || root == q) ? 1 : 0;

    if (curr + left + right >= 2)
      lc.add(root);

    // Return true if any one of three bool values is True
    return (curr + left + right) > 0;
  }
  */

  // Straight Idea
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // stack for tree traversal
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);

    // hashmap for parent pointer
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    parent.put(root, null);

    // find both p and q
    while (!parent.containsKey(p) || !parent.containsKey(q)) {
      TreeNode node = stack.pop();

      if (node.left != null) {
        stack.push(node.left);
        parent.put(node.left, node);
      }

      if (node.right != null) {
        stack.push(node.right);
        parent.put(node.right, node);
      }
    }

    // ancestor set for node p
    Set<TreeNode> ancestors = new HashSet<>();
    while (p != null) {
      ancestors.add(p);
      p = parent.get(p);
    }

    // first ancestor of q which appears in p's ancestor set
    while (!ancestors.contains(q)) {
      q = parent.get(q);
    }

    return q;
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
