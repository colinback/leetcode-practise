package shizy.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * 
 * Example, given the following triangle:
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */

public class Practise120 {
    public static void main(String[] args) {
        Practise120 p = new Practise120();

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(p.minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        if (rows == 0)
            return 0;

        // keep mininum path sum
        int[][] dp = new int[rows][rows];

        // init
        dp[0][0] = triangle.get(0).get(0);
        // for(int i = 1; i < rows; i++)
        // Arrays.fill(dp[i], Integer.MAX_VALUE);

        int minPathSum = Integer.MAX_VALUE;

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0)
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                else if (j == i)
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
        }

        for (int j = 0; j < rows; j++)
            minPathSum = Math.min(minPathSum, dp[rows - 1][j]);

        return minPathSum;
    }
}