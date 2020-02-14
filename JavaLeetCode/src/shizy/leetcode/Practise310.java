package shizy.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * For an undirected graph with tree characteristics, we can choose any node as the root.
 * The result graph is then a rooted tree. Among all possible rooted trees, those with
 * minimum height are called minimum height trees (MHTs). Given such a graph, write a
 * function to find all the MHTs and return a list of their root labels.
 * 
 * Example 1
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * 
 *         0
 *         |
 *         1
 *        / \
 *       2   3
 * 
 * Output: [1]
 * 
 * Example 2:
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * 
 *      0  1  2
 *       \ | /
 *         3
 *         |
 *         4
 *         |
 *         5 
 * 
 * Output: [3, 4]
 */

public class Practise310 {
    public static void main(String[] args) {
        Practise310 p = new Practise310();

        System.out.println(
                p.findMinHeightTrees(4, new int[][] { new int[] { 1, 0 }, new int[] { 1, 2 }, new int[] { 1, 3 } }));

        System.out.println(p.findMinHeightTrees(6, new int[][] { new int[] { 0, 3 }, new int[] { 1, 3 },
                new int[] { 2, 3 }, new int[] { 4, 3 }, new int[] { 5, 4 } }));

        System.out.println(p.findMinHeightTrees(1, new int[][] {}));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return Arrays.asList(0);

        // adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        List<Integer> leaves = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            if (graph.get(i).size() == 1)
                leaves.add(i);
        }

        while (n > 2) {
            n -= leaves.size();

            // remove leaves and find new leaves
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = graph.get(i).iterator().next();
                graph.get(j).remove(Integer.valueOf(i));
                if (graph.get(j).size() == 1)
                    newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    // private int dfs(int v, List<List<Integer>> graph, boolean[] visited, int
    // height) {
    // visited[v] = true;

    // int maxHeight = height;
    // for (int w : graph.get(v)) {
    // if (!visited[w]) {
    // maxHeight = Math.max(maxHeight, dfs(w, graph, visited, height + 1));
    // }
    // }

    // return maxHeight;
    // }
}