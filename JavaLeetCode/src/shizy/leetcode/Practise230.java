package shizy.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Example 1:
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * 
 * Example 2:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 */

public class Practise230 {
  class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    Practise230 p = new Practise230();

    // TreeNode root = p.makeTree(new int[] { 3, 1, 4, -1, 2 }, 0);
    // System.out.println(p.kthSmallest(root, 1));

    TreeNode root = p.makeTree(new int[] { 5, 3, 6, 2, 4, -1, -1, 1 }, 0);
    System.out.println(p.kthSmallest(root, 4));
  }

  // DFS
  public int kthSmallest(TreeNode root, int k) {
    assert (root != null);

    List<Integer> list = new ArrayList<>();
    dfs(root, list, k);
    return list.get(k - 1);
  }

  // inorder
  private void dfs(TreeNode root, List<Integer> list, int k) {
    if (root == null)
      return;

    if (list.size() < k)
      dfs(root.left, list, k);

    if (list.size() < k)
      list.add(root.val);

    if (list.size() < k)
      dfs(root.right, list, k);
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
