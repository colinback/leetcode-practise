package shizy.leetcode;

/*
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are all
 * surrounded by water.
 * 
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * Output: 1
 * 
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * Output: 3
 */

public class Practise200 {
    public static void main(String[] args) {
        Practise200 p = new Practise200();

        // char[][] grid = new char[][] {
        // new char[] {'1', '1', '1', '1', '0'},
        // new char[] {'1', '1', '0', '1', '0'},
        // new char[] {'1', '1', '0', '0', '0'},
        // new char[] {'0', '0', '0', '0', '0'}
        // };

        char[][] grid = new char[][] { new char[] { '1', '1', '0', '0', '0' }, new char[] { '1', '1', '0', '0', '0' },
                new char[] { '0', '0', '1', '0', '0' }, new char[] { '0', '0', '0', '1', '1' } };
        System.out.println(p.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][];
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            visited[i] = new boolean[grid[i].length];
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, visited, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[i].length)
            return;

        if (visited[i][j] || grid[i][j] == '0')
            return;

        visited[i][j] = true;

        dfs(grid, visited, i - 1, j); // left
        dfs(grid, visited, i + 1, j); // right
        dfs(grid, visited, i, j - 1); // top
        dfs(grid, visited, i, j + 1); // down
    }
}