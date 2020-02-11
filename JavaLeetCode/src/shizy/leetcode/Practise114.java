package shizy.leetcode;

/*
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * Example:
 * Given the below binary tree and sum = 22,
 *       1
 *      / \
 *     2   5
 *    / \   \
 *   3   4   6
 * 
 * Return:
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */

public class Practise114 {
  class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    Practise114 p = new Practise114();

    TreeNode root = p.makeTree(new int[] { 1, 2, 5, 3, 4, -1, 6 }, 0);

    p.flatten(root);
    System.out.println(root);
  }

  public void flatten(TreeNode root) {
    if (root == null)
      return;

    flatten(root.left);
    flatten(root.right);

    // root.right <- root.left
    TreeNode right = root.right;
    root.right = root.left;
    root.left = null;

    // find bottom right of current node
    TreeNode br = root;
    while (br.right != null) {
      br = br.right;
    }

    // br.right <- right
    br.right = right;
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
