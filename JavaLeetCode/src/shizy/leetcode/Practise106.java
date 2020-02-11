package shizy.leetcode;

/*
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Example, given:
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * 
 * Return the following binary tree:
 * 
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */

public class Practise106 {
    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Practise106 p = new Practise106();

        TreeNode root = p.buildTree(new int[] { 9, 3, 15, 20, 7 }, new int[] { 9, 15, 7, 20, 3 });

        System.out.println(root);
    }

    // Recursive
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        assert (postorder.length == inorder.length);

        if (postorder.length == 0)
            return null;

        return buildNodeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildNodeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart,
            int postEnd) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        // find postorder[postEnd] in inorder array
        int count = 0;
        while (inorder[inStart + count] != postorder[postEnd])
            count++;

        root.left = buildNodeHelper(inorder, inStart, inStart + count - 1, postorder, postStart, postStart + count - 1);
        root.right = buildNodeHelper(inorder, inStart + count + 1, inEnd, postorder, postStart + count, postEnd - 1);

        return root;
    }
}