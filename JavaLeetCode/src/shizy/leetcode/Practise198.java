package shizy.leetcode;

/*
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount
 * of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses
 * have security system connected and it will automatically contact the police if two adjacent houses were
 * broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, determine the
 * maximum amount of money you can rob tonight without alerting the police.
 * 
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * 
 * Example 2:
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 */

public class Practise198 {
    public static void main(String[] args) {
        Practise198 p = new Practise198();

        System.out.println(p.rob(new int[] {1, 2, 3, 1}));
        System.out.println(p.rob(new int[] {2, 7, 9, 3 ,1}));
        System.out.println(p.rob(new int[] {2, 7, 1, 2, 11, 3 ,1}));
    }

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        int[] amount = new int[nums.length];

        // init amount[0] & amount[1]
        amount[0] = nums[0];
        amount[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            amount[i] = Math.max(nums[i] + amount[i - 2], amount[i - 1]);
        }

        return amount[nums.length - 1];
    }
}