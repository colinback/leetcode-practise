package shizy.leetcode;

import java.util.Arrays;
import java.util.Queue;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Given an m x n matrix of positive integers representing the height of
 * each unit cell in a 2D elevation map, compute the volume of water it
 * is able to trap after raining.
 * 
 * Example:
 * Given the following 3x6 height map:
 * [
 *   [1,4,3,1,3,2],
 *   [3,2,1,3,2,4],
 *   [2,3,3,2,3,1]
 * ]
 * 
 * Return 4.
 */

public class Practise407 {
    class Cell {
        int x;
        int y;
        int height;

        public Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        Practise407 p = new Practise407();

        int[][] heightMap1 = { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };
        System.out.println(p.trapRainWater(heightMap1));

        int[][] heightMap2 = { { 5, 5, 5, 1 }, { 5, 1, 1, 5 }, { 5, 1, 5, 5 }, { 5, 2, 5, 8 } };
        System.out.println(p.trapRainWater(heightMap2));

        int[][] heightMap3 = { { 2, 3, 4 }, { 5, 6, 7 }, { 8, 9, 10 }, { 11, 12, 13 }, { 14, 15, 16 } };
        System.out.println(p.trapRainWater(heightMap3));
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0)
            return 0;

        int rows = heightMap.length;
        int cols = heightMap[0].length;

        // visited flag
        boolean[][] visited = new boolean[rows][cols];

        // priority queue - min priority
        Queue<Cell> queue = new PriorityQueue<>(1, new Comparator<Cell>() {
            public int compare(Cell a, Cell b) {
                return a.height - b.height;
            }
        });

        // add border cells to the queue
        for (int i = 0; i < rows; i++) {
            visited[i][0] = true;
            visited[i][cols - 1] = true;
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            queue.offer(new Cell(i, cols - 1, heightMap[i][cols - 1]));
        }

        for (int j = 1; j < cols - 1; j++) {
            visited[0][j] = true;
            visited[rows - 1][j] = true;
            queue.offer(new Cell(0, j, heightMap[0][j]));
            queue.offer(new Cell(rows - 1, j, heightMap[rows - 1][j]));
        }

        // from the borders, pick the lowest cell visited and check its neighbors:
        // if the neighbor is lower, collect the water it can trap and update its
        // height as its height plus the water trapped add all its neighbors to the
        // queue.
        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        int rainWater = 0;

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();

            for (int[] dir : dirs) {
                int x = cell.x + dir[0];
                int y = cell.y + dir[1];

                if (x < 0 || x >= rows || y < 0 || y >= cols)
                    continue;

                if (!visited[x][y]) {
                    visited[x][y] = true;

                    if (cell.height > heightMap[x][y])
                        rainWater += cell.height - heightMap[x][y];

                    queue.offer(new Cell(x, y, Math.max(heightMap[x][y], cell.height)));
                }
            }
        }

        return rainWater;
    }
}