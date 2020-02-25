package shizy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given an m x n matrix of non-negative integers representing the height of each unit cell
 * in a continent, the "Pacific ocean" touches the left and top edges of the matrix and
 * the "Atlantic ocean" touches the right and bottom edges.
 * 
 * Water can only flow in four directions (up, down, left, or right) from a cell to another
 * one with height equal or lower.
 * 
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * 
 * Example:
 * 
 * Given the following 5x5 matrix:
 * 
 *   Pacific ~   ~   ~   ~   ~ 
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * Atlantic
 * 
 * Return:
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */

public class Practise417 {
    public static void main(String[] args) {
        Practise417 p = new Practise417();

        // int[][] matrix = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, {
        // 6, 7, 1, 4, 5 },
        // { 5, 1, 1, 2, 4 } };
        // int[][] matrix = {{1,2,3},{8,9,4},{7,6,5}};
        int[][] matrix = { { 3, 3, 3 }, { 3, 1, 3 }, { 0, 2, 4 } };
        System.out.println(p.pacificAtlantic(matrix));
    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0)
            return new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        // visited
        boolean[][] visited_lt = new boolean[rows][];
        boolean[][] visited_rb = new boolean[rows][];
        for (int i = 0; i < rows; i++) {
            visited_lt[i] = new boolean[cols];
            visited_rb[i] = new boolean[cols];
        }

        // list of grid coordinates where water can flow to both the Pacific and
        // Atlantic ocean
        List<List<Integer>> positions = new ArrayList<>();

        Queue<int[]> queue = new LinkedList<>();

        // direction: right, down, left, top
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        // First pass: check for left and top
        for (int i = 0; i < rows; i++)
            queue.offer(new int[] { i, 0 });
        for (int j = 1; j < cols; j++)
            queue.offer(new int[] { 0, j });

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            visited_lt[cell[0]][cell[1]] = true;

            for (int idx = 0; idx < 4; idx++) {
                int x = cell[0] + dirs[idx][0];
                int y = cell[1] + dirs[idx][1];

                if (x < 0 || x >= rows || y < 0 || y >= cols)
                    continue;

                if (!visited_lt[x][y]) {
                    if (matrix[cell[0]][cell[1]] <= matrix[x][y])
                        queue.offer(new int[] { x, y });
                }
            }
        }

        // System.out.println(Arrays.deepToString(visited_lt));

        // Second pass: check for right and bottom
        for (int i = 0; i < rows; i++)
            queue.offer(new int[] { i, cols - 1 });
        for (int j = 0; j < cols - 1; j++)
            queue.offer(new int[] { rows - 1, j });

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            visited_rb[cell[0]][cell[1]] = true;

            for (int idx = 0; idx < 4; idx++) {
                int x = cell[0] + dirs[idx][0];
                int y = cell[1] + dirs[idx][1];

                if (x < 0 || x >= rows || y < 0 || y >= cols)
                    continue;

                if (!visited_rb[x][y]) {
                    if (matrix[cell[0]][cell[1]] <= matrix[x][y])
                        queue.offer(new int[] { x, y });
                }
            }
        }

        // System.out.println(Arrays.deepToString(visited_rb));

        // find positions
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (visited_lt[i][j] && visited_rb[i][j])
                    positions.add(Arrays.asList(i, j));

        return positions;
    }
}