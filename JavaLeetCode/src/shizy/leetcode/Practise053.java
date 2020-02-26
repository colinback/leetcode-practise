package shizy.leetcode;

/*
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * 
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */

public class Practise053 {
    public static void main(String[] args) {
        Practise053 p = new Practise053();

        System.out.println(p.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;

        // dp[i] means the maximum subarray ending with nums[i];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        // remember max
        int maxValue = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            maxValue = Math.max(maxValue, dp[i]);
        }

        return maxValue;
    }

    /*
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;

        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }

    // divide and conquer
    private int maxSubArrayHelper(int[] nums, int lo, int hi) {
        if (lo == hi)
            return nums[lo];

        int mid = (lo + hi) / 2;

        int leftMax = maxSubArrayHelper(nums, lo, mid);
        int rightMax = maxSubArrayHelper(nums, mid + 1, hi);

        // the maximum subarray does contain the middle element
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;

        int sum = 0;
        for (int i = mid; i >= lo; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        sum = 0;
        for (int j = mid + 1; j <= hi; j++) {
            sum += nums[j];
            rightSum = Math.max(rightSum, sum);
        }

        return Math.max(Math.max(leftMax, rightMax), leftSum + rightSum);
    }
    */
}