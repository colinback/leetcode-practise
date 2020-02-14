package shizy.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
 * Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection
 * link to be reconstructed later in the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction
 * on how your serialization/deserialization algorithm should work. You just need to ensure that a
 * binary search tree can be serialized to a string and this string can be deserialized to the
 * original tree structure.
 * 
 * The encoded string should be as compact as possible.
 */

public class Practise449 {
  class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    Practise449 p = new Practise449();

    TreeNode root = p.makeTree(new int[] { 3, 1, 4, -1, 2 }, 0);
    // TreeNode root = p.makeTree(new int[] {}, 0);
    // Your Codec object will be instantiated and called as such:
    String codes = p.serialize(root);
    System.out.println(codes);
    System.out.println(p.deserialize(codes));
  }

  // Encodes a tree to a single string.
  /*
  public String serialize(TreeNode root) {
    if (root == null)
      return "null";

    // pre-order array
    List<String> nums = new ArrayList<>();

    // iteratively
    Stack<TreeNode> st = new Stack<>();
    st.push(root);
    while (!st.empty()) {
      root = st.pop();
      nums.add(String.valueOf(root.val));

      if (root.right != null)
        st.push(root.right);

      if (root.left != null)
        st.push(root.left);
    }

    return String.join("|", nums);
  }
  */

  public String serialize(TreeNode root) {
    if (root == null)
      return "null";

    // pre-order array
    List<String> nums = new ArrayList<>();

    // recursive
    preorder(root, nums);

    return String.join(",", nums);
  }

  private void preorder(TreeNode root, List<String> nums) {
    if (root == null)
      return;

    nums.add(String.valueOf(root.val));

    if (root.left != null)
      preorder(root.left, nums);

    if (root.right != null)
      preorder(root.right, nums);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.equals("null"))
      return null;

    String[] strs = data.split(",");
    System.out.println(Arrays.toString(strs));
    List<Integer> nums = new ArrayList<>();

    for(String s: strs) {
      nums.add(Integer.parseInt(s));
    }

    return buildTree(nums);
  }

  private TreeNode buildTree(List<Integer> nums) {
    if (nums.isEmpty())
      return null;

    TreeNode root = new TreeNode(nums.get(0));
    
    int pos = 1;
    while(pos < nums.size() && nums.get(pos) < nums.get(0))
      pos++;

    root.left = buildTree(nums.subList(1, pos));
    root.right = buildTree(nums.subList(pos, nums.size()));

    return root;
  }

  public TreeNode makeTree(int[] nums, int idx) {
    TreeNode root = null;

    if (nums.length == 0)
      return null;

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
