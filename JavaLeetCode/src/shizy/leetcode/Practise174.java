package shizy.leetcode;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

/*
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon.
 * The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially
 * positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
 * 
 * Example:
 * Input:
 * [
 *  [ -2(K), -3, 3]
 *  [ -5, -10, 1]
 *  [ 10, 30, -5(P)]
 * ]
 * Output: 7
 * Explanation: RIGHT-> RIGHT -> DOWN -> DOWN
 */

public class Practise174 {
    public static void main(String[] args) {
        Practise174 p = new Practise174();

        int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
        // int[][] dungeon = { { 0, 5}, { -2, -3} };
        // int[][] dungeon = { { 2 }, { 1 } };
        System.out.println(p.calculateMinimumHP(dungeon));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0)
            return 0;

        int rows = dungeon.length;
        int cols = dungeon[0].length;

        // mininum health, dp[i][j] should not drops to 0 or below
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[rows - 1][cols - 1] = Math.max(1 - dungeon[rows - 1][cols - 1], 1);

        // right border
        for (int i = rows - 2; i >= 0; i--)
            dp[i][cols - 1] = Math.max(dp[i + 1][cols - 1] - dungeon[i][cols - 1], 1);

        // bottom border
        for (int j = cols - 2; j >= 0; j--)
            dp[rows - 1][j] = Math.max(dp[rows - 1][j + 1] - dungeon[rows - 1][j], 1);

        // bottom-right to top-left
        for (int i = rows - 2; i >= 0; i--)
            for (int j = cols - 2; j >= 0; j--)
                // min of down and right
                dp[i][j] = Math.min(Math.max(dp[i + 1][j] - dungeon[i][j], 1),
                        Math.max(dp[i][j + 1] - dungeon[i][j], 1));

        System.out.println(Arrays.deepToString(dp));

        // inital health
        return dp[0][0];
    }
}