package shizy.leetcode;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
 * which minimizes the sum of all numbers along its path.
 * 
 * Example:
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

public class Practise064 {
	public static void main(String[] args) {
		Practise064 p = new Practise064();

		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println(p.minPathSum(grid));
	}

	public int minPathSum(int[][] grid) {
		if (grid.length == 0)
			return 0;

		int rows = grid.length;
		int cols = grid[0].length;

		// mininum path sum at grid[i][j]
		int[][] dp = new int[rows][cols];
		for (int i = 0; i < rows; i++)
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		dp[0][0] = grid[0][0];

		// init queue
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0 });

		// directions
		int[][] dirs = { { 1, 0 }, { 0, 1 } };

		// BFS
		while (!queue.isEmpty()) {
			int[] cell = queue.poll();

			for (int[] dir : dirs) {
				int x = cell[0] + dir[0];
				int y = cell[1] + dir[1];

				if (x < 0 || x >= rows || y < 0 || y >= cols)
					continue;

				if (dp[x][y] > dp[cell[0]][cell[1]] + grid[x][y]) {
					dp[x][y] = dp[cell[0]][cell[1]] + grid[x][y];
					queue.offer(new int[] { x, y });
				}
			}
		}

		return dp[rows - 1][cols - 1];
	}
}
