package shizy.leetcode;

import java.util.Arrays;

/*
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * 
 * Example
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4 
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
 */

public class Practise300 {
    public static void main(String[] args) {
        Practise300 p = new Practise300();

        System.out.println(p.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;

        // length of the longest increasing subsequence of subarray whose last item is
        // nums[i]
        int[] dp = new int[nums.length];
        dp[0] = 1;

        // output
        int res = 1;

        for (int i = 1; i < nums.length; i++) {
            // find maxinum length from dp[0] to dp[i-1]
            int max_dp = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++)
                max_dp = Math.max(max_dp, (nums[i] > nums[j] ? dp[j] : 0));

            // update dp[i]
            dp[i] = max_dp + 1;
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}