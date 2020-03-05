package shizy.leetcode;

/*
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it
 * represented by array nums. You are asked to burst all the balloons. If the you burst
 * balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right
 * are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * 
 * Example:
 * Input: [3,1,5,8]
 * Output: 167 
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *              coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */

public class Practise312 {
    public static void main(String[] args) {
        Practise312 p = new Practise312();

        System.out.println(p.maxCoins(new int[] { 3, 1, 5, 8 }));
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;

        if (n == 0)
            return 0;

        // coins: [1, nums, 1]
        int[] coins = new int[n + 2];
        coins[0] = coins[n + 1] = 1;
        for (int i = 1; i < n + 1; i++)
            coins[i] = nums[i - 1];

        // devide problem by the last ballon to burst, not include begin and end
        int[][] dp = new int[n + 2][n + 2];

        // dynamic programming (bottom up) - O(n^3)
        for (int k = 2; k < n + 2; k++) { // interval
            for (int i = 0; i < n + 2 - k; i++) { // left
                int j = i + k; // right

                // all possible last ballon to burst
                for (int m = i + 1; m < j; m++) {
                    dp[i][j] = Math.max(dp[i][j], coins[i] * coins[m] * coins[j] + dp[i][m] + dp[m][j]);
                }
            }
        }

        // System.out.println(Arrays.deepToString(dp));

        return dp[0][n + 1];
    }
}