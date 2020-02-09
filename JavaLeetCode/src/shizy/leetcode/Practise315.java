package shizy.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

/*
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements
 * to the right of nums[i].
 * 
 * Example
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * 
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 */

 public class Practise315 {
    public static void main(String[] args) {
        Practise315 p = new Practise315();

        System.out.println(p.countSmaller(new int[] {5, 2, 6, 1}));
        //System.out.println(p.countSmaller(new int[] {}));

        List<Integer> nums = Arrays.asList(1, 3, 3, 5, 7, 9);
        System.out.println(p.binarySearch(nums, 3));
    }

    // Merge Sort
    /*
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();

        int[] count = new int[nums.length];
        int[] idxs = new int[nums.length];
        for (int i = 0; i < idxs.length; i++)
            idxs[i] = i;

        mergeSort(nums, idxs, 0, nums.length - 1, count);

        List<Integer> output = new ArrayList<>();
        for(int i : count)
            output.add(i);

        return output;
    }

    private void mergeSort(int[] nums, int[] idxs, int lo, int hi, int[] count) {
        if (lo >= hi)
            return;

        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, idxs, lo, mid, count);
        mergeSort(nums, idxs, mid + 1, hi, count);

        merge(nums, idxs, lo, mid, hi, count);
    }

    private void merge(int[] nums, int[] idxs, int lo, int mid, int hi, int[] count) {
        int[] sorted = new int[hi - lo + 1];
        int[] pos = new int[hi - lo + 1];

        int i = lo, j = mid + 1;
        int k = 0;
        while(k <= hi - lo) {
            if (i <= mid) {
                if (j <= hi && nums[i] > nums[j]) {
                    // 左数组i比右数组j大，则取出右数组j
                    pos[k] = idxs[j];
                    sorted[k++] = nums[j++];
                } else {
                    // 1. 左数组i比右数组小，取出左数组i，更新count
                    // 2. 右数组处理完毕，所有右数组数字均比当前左数组i小
                    count[idxs[i]] += j - mid - 1;
                    pos[k] = idxs[i];
                    sorted[k++] = nums[i++];
                }
            } else {
                // 左数组处理完毕
                pos[k] = idxs[j];
                sorted[k++] = nums[j++];
            }
        }

        // copy position
        System.arraycopy(pos, 0, idxs, lo, hi - lo + 1);

        // copy sorted array to original nums
        System.arraycopy(sorted, 0, nums, lo, hi - lo + 1);
    }
    */

    // Segment Tree
    /*
    class SegTreeNode {
        int min, max;  // range [min, max]
        int count;
        SegTreeNode left, right;

        public SegTreeNode(int min, int max) {
            this.min = min;
            this.max = max;
            count = 0;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        SegTreeNode root = new SegTreeNode(min, max);

        for(int i = nums.length - 1; i >= 0; i--) {
            list.add(0, find(nums[i] - 1, root)); // minus 1, in case there is a equal one
            add(nums[i], root);
        }

        return list;
    }

    private void add(int x, SegTreeNode root) {
        if (x < root.min || x > root.max)
            return;

        root.count++;
        if (root.min == root.max)
            return;

        int mid = (root.min + root.max) / 2;
        if (x <= mid) {
            if (root.left == null)
                root.left = new SegTreeNode(root.min, mid);
            add(x, root.left);
        } else {
            if (root.right == null)
                root.right = new SegTreeNode(mid + 1, root.max);
            add(x, root.right);
        }
    }

    private int find(int x, SegTreeNode root) {
        if (root == null)
            return 0;

        if (x >= root.max) {
            return root.count;
        } else {
            int mid = (root.min + root.max) / 2;

            if (x <= mid) {
                return find(x, root.left);
            } else {
                return find(x, root.left) + find(x, root.right);
            }
        }
    }
    */

    // Binary Search
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();

        List<Integer> sorted = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for(int i = nums.length - 1; i >=0; i--) {
            int idx = binarySearch(sorted, nums[i]);
            sorted.add(idx, nums[i]);
            list.add(0, idx);
        }

        return list;
    }

    // duplicate version
    public int binarySearch(List<Integer> nums, int x) {
        int lo = 0, hi = nums.size();

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (nums.get(mid) < x)
                lo = mid + 1;
            else
                hi = mid;
        }

        return lo;
    }
 }