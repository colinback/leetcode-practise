package shizy.leetcode;

import java.util.Arrays;

/*
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Example, given:
 *  preorder = [3,9,20,15,7]
 *  inorder = [9,3,15,20,7]
 * 
 * Return the following binary tree:
 * 
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */

public class Practise105 {
    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Practise105 p = new Practise105();

        p.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
    }

    // Recursive
    public TreeNode buildTree(int[] preorder, int[] inorder) {        
        assert(preorder.length == inorder.length);

        if (preorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1)
            return root;

        // find preorder[0] in inorder array
        int pos = 0;
        while(inorder[pos] != preorder[0])
            pos++;

        int[] left_preorder = Arrays.copyOfRange(preorder, 1, pos + 1);
        int[] left_inorder = Arrays.copyOfRange(inorder, 0, pos);
        int[] right_preorder = Arrays.copyOfRange(preorder, pos + 1, preorder.length);
        int[] right_inorder = Arrays.copyOfRange(inorder, pos + 1, preorder.length);

        // System.out.println("left_preorder");
        // System.out.println(Arrays.toString(left_preorder));
        // System.out.println("left_inorder");
        // System.out.println(Arrays.toString(left_inorder));
        // System.out.println("right_preorder");
        // System.out.println(Arrays.toString(right_preorder));
        // System.out.println("right_inorder");
        // System.out.println(Arrays.toString(right_inorder));

        root.left = buildTree(left_preorder, left_inorder);
        root.right = buildTree(right_preorder, right_inorder);

        return root;
    }
}