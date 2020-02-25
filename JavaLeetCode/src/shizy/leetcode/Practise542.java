package shizy.leetcode;

import java.util.Stack;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

/* 
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 * 
 * Example 1:
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 * 
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [0,0,0]]
 * 
 * Example 2:
 * Input:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,1,1]]
 * 
 * Output:
 * [[0,0,0],
 *  [0,1,0],
 *  [1,2,1]]
 */

public class Practise542 {
    class Tuple<X, Y> {
        public final X x;
        public final Y y;

        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object other) {
            if (other instanceof Tuple<?, ?>) {
                Tuple<?, ?> o = (Tuple<?, ?>) other;
                return this.x.equals(o.x) && this.y.equals(o.y);
            }
            return false;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((x == null) ? 0 : x.hashCode());
            result = prime * result + ((y == null) ? 0 : y.hashCode());
            return result;
        }
    }

    public static void main(String[] args) {
        Practise542 p = new Practise542();

        // input
        int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };

        // System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepToString(p.updateMatrix(matrix)));
    }

    // BFS
    public int[][] updateMatrix(int[][] matrix) {
        // Stack<Tuple<Integer, Integer>> stack = new Stack<>();
        Queue<int[]> queue = new LinkedList<>();

        // distance matrix
        int[][] dist = new int[matrix.length][];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = new int[matrix[i].length];
            for (int j = 0; j < dist[i].length; j++)
                dist[i][j] = Integer.MAX_VALUE;
        }

        // init all 0
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                    queue.offer(new int[] { i, j });
                }

        // direction
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int distance = dist[cell[0]][cell[1]];

            for (int[] d : dirs) {
                int x = cell[0] + d[0];
                int y = cell[1] + d[1];

                if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[x].length)
                    continue;

                if (dist[x][y] > distance + 1) {
                    // distance update
                    queue.offer(new int[] { x, y });
                    dist[x][y] = distance + 1;
                }
            }
        }

        return dist;
    }

    /*
    // DP
    public int[][] updateMatrix(int[][] matrix) {
        {
            int rows = matrix.length;
            if (rows == 0)
                return matrix;

            int cols = matrix[0].length;

            int[][] dist = new int[rows][];
            for (int i = 0; i < dist.length; i++) {
                dist[i] = new int[cols];
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }

            // First pass: check for left and top
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] == 0)
                        dist[i][j] = 0;
                    else {
                        if (i > 0)
                            dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                        if (j > 0)
                            dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                    }
                }
            }

            // Second pass: check for bottom and right
            for (int i = rows - 1; i >= 0; i--) {
                for (int j = cols - 1; j >= 0; j--) {
                    if (i < rows - 1)
                        dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                    if (j < cols - 1)
                        dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                }
            }

            return dist;
        }
    }
    */
}