package shizy.leetcode;

import java.util.Queue;
import java.util.LinkedList;

/*
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * 
 * Example:
 * Given nums = [1, 3, 5]
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 */

public class Practise307 {
    class SegTreeNode {
        int min, max;  // range [min, max]
        int sum;
        SegTreeNode left, right;

        public SegTreeNode(int min, int max) {
            this.min = min;
            this.max = max;
            sum = 0;
        }
    }

    /*
    class NumArray {
        private SegTreeNode root;

        private void add(int[] nums, int idx, SegTreeNode root) {
            if (idx < root.min || idx > root.max)
                return;

            root.sum += nums[idx];

            if (root.min == root.max)
                return;

            int mid = (root.min + root.max) / 2;
            if (idx <= mid) {
                if (root.left == null)
                    root.left = new SegTreeNode(root.min, mid);

                add(nums, idx, root.left);
            } else {
                if (root.right == null)
                    root.right = new SegTreeNode(mid + 1, root.max);

                add(nums, idx, root.right);
            }
        }

        private int sumLessThan(int idx, SegTreeNode root) {
            if (root == null)
                return 0;
            
            if (idx > root.max)
                return root.sum;
            else {
                int mid = (root.min + root.max) / 2;

                if (idx <= mid) {
                    return sumLessThan(idx, root.left);
                } else {
                    return sumLessThan(idx, root.left) + sumLessThan(idx, root.right);
                }
            }
        }

        public NumArray(int[] nums) {
            root = new SegTreeNode(0, nums.length - 1);

            for(int i = 0; i < nums.length; i++) {
                add(nums, i, root);
            }
        }
        
        public void update(int i, int val) {
            Queue<SegTreeNode> queue = new LinkedList<>();
            SegTreeNode curr = root;

            int preVal = 0;

            while(curr != null) {
                queue.offer(curr);

                if (curr.min == curr.max) {
                    preVal = curr.sum;
                    break;
                }

                int mid = (curr.min + curr.max) / 2;

                if (i <= mid)
                    curr = curr.left;
                else
                    curr = curr.right;
            }

            while(!queue.isEmpty()) {
                SegTreeNode n = queue.poll();
                n.sum = n.sum + val - preVal;
            }
        }
        
        public int sumRange(int i, int j) {
            return sumLessThan(j + 1, root) - sumLessThan(i, root);

        }
    }
    */

    // array implementation (index 2i and 2i + 1 are left child and right child respectively)
    class NumArray {
        int[] tree;
        int n;

        public NumArray(int[] nums) {
            tree = new int[nums.length * 2];
            n = nums.length;
            buildTree(nums);
        }

        private void buildTree(int[] nums) {
            for (int i = n, j = 0; i < 2 * n; i++, j++)
                tree[i] = nums[j];

            for (int i = n - 1; i > 0; i--)
                tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

        void update(int pos, int val) {
            pos += n;
            tree[pos] = val;
            while (pos > 0) {
                int left = pos;
                int right = pos;
                if (pos % 2 == 0) {
                    right = pos + 1;
                } else {
                    left = pos - 1;
                }
                // parent is updated after child is updated
                tree[pos / 2] = tree[left] + tree[right];
                pos /= 2;
            }
        }

        public int sumRange(int l, int r) {
            // get leaf with value 'l'
            l += n;
            // get leaf with value 'r'
            r += n;
            int sum = 0;
            while (l <= r) {
                if ((l % 2) == 1) {
                   sum += tree[l];
                   l++;
                }
                if ((r % 2) == 0) {
                   sum += tree[r];
                   r--;
                }
                l /= 2;
                r /= 2;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Practise307 p = new Practise307();

        int[] nums = {2, 4, 5, 7, 8, 9};
        // int[] nums = {-1};
        NumArray na = p.new NumArray(nums);

        System.out.println(na.sumRange(0, 2));
        na.update(0, 1);
        System.out.println(na.sumRange(0, 3));
    }
}