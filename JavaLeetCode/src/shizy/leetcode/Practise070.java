package shizy.leetcode;

/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * Example 2:
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */

public class Practise070 {
    public static void main(String[] args) {
        Practise070 p = new Practise070();

        System.out.println(p.climbStairs(2));
        System.out.println(p.climbStairs(3));
    }

    public int climbStairs(int n) {
        int[] climbs = new int[n + 1];
        climbs[0] = 1;
        climbs[1] = 1;

        for (int i = 2; i <= n; i++)
            climbs[i] = climbs[i - 1] + climbs[i - 2];

        return climbs[n];
    }
}