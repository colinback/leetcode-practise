package shizy.leetcode;

import java.util.List;
import java.util.ArrayList;

/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * Given the below binary tree and sum = 22,
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * 
 * Return:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]

 */

public class Practise113 {
  class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    Practise113 p = new Practise113();

    TreeNode root = p.makeTree(new int[] { 5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, -1, -1, 5, 1 }, 0);

    System.out.println(p.pathSum(root, 22));
    System.out.println(p.pathSum(null, 2));
  }

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    if (root == null)
      return new ArrayList<>();

    List<List<Integer>> outputs = new ArrayList<>();

    pathSumHelper(root, sum, outputs, new ArrayList<>());

    return outputs;
  }

  private void pathSumHelper(TreeNode root, int sum, List<List<Integer>> outputs, List<Integer> res) {
    res.add(root.val);

    // leaf node
    if (root.left == null && root.right == null) {
      if (sum == root.val)
        outputs.add(new ArrayList<>(res));
    }

    if (root.left != null)
      pathSumHelper(root.left, sum - root.val, outputs, res);

    if (root.right != null)
      pathSumHelper(root.right, sum - root.val, outputs, res);

    // back trace
    res.remove(res.size() - 1);
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
