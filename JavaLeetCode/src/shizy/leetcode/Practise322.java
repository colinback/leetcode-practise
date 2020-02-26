package shizy.leetcode;

import java.util.Arrays;

/*
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up
 * that amount. If that amount of money cannot be made up by any combination of the coins,
 * return -1.
 * 
 * Example 1:
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3 
 * Explanation: 11 = 5 + 5 + 1
 * 
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 */

public class Practise322 {
    public static void main(String[] args) {
        Practise322 p = new Practise322();

        System.out.println(p.coinChange(new int[] { 1, 2, 5 }, 10));
        System.out.println(p.coinChange(new int[] { 2 }, 3));
        System.out.println(p.coinChange(new int[] { 1 }, 0));
    }

    public int coinChange(int[] coins, int amount) {
        // remember min coins for amount
        int[] dp = new int[amount + 1];

        // init
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
}