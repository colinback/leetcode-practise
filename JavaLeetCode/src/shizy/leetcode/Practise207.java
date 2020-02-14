package shizy.leetcode;

import java.util.List;
import java.util.ArrayList;

import java.util.Deque;
import java.util.ArrayDeque;

/*
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
 * which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you
 * to finish all courses?
 *
 * Example 1
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 *              To take course 1 you should have finished course 0. So it is possible.
 * 
 * Example 2
 * Input: 2, [[1,0]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 */

public class Practise207 {
  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    Practise207 p = new Practise207();

    System.out.println(p.canFinish(2, new int[][] { new int[] { 1, 0 } }));
    System.out.println(p.canFinish(2, new int[][] { new int[] { 1, 0 }, new int[] { 0, 1 } }));

    System.out.println(p.canFinish(4, new int[][] { new int[] { 0, 1 }, new int[] { 3, 1 }, new int[] { 1, 3}, new int[] {3, 2} }));
    System.out.println(p.canFinish(3, new int[][] { new int[] { 0, 1 }, new int[] { 0, 2 }, new int[] { 1, 2 } }));

    System.out.println(p.canFinish(4, new int[][] {
      new int[] { 2, 0 }, new int[] { 1, 0 }, new int[] { 3, 1 },
      new int[] { 3, 2 }, new int[] { 1, 3 }
    }));
  }

  // DFS (recursive)
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (numCourses <= 0 || prerequisites.length == 0)
      return true;

    boolean[] visited = new boolean[numCourses];

    // Adjacency lists
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++)
      graph.add(new ArrayList<>());

    for (int i = 0; i < prerequisites.length; i++) {
      graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
    }

    // for all vertexes
    for (int v = 0; v < numCourses; v++) {
      if (dfs(v, visited, graph))
        return false;
    }

    return true;
  }

  // Return true if cycle is detected
  private boolean dfs(int v, boolean[] visited, List<List<Integer>> graph) {
    // stack push
    visited[v] = true;

    for (int w : graph.get(v)) {
      if (visited[w] || dfs(w, visited, graph))
        return true;
    }

    // stack pop
    visited[v] = false;

    return false;
  }
  
  // DFS (stack version)
  /*
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (numCourses <= 0 || prerequisites.length == 0)
      return true;

    // Adjacency lists
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < numCourses; i++)
      graph.add(new ArrayList<>());

    for (int i = 0; i < prerequisites.length; i++) {
      graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
    }

    // for all vertexes
    for (int v = 0; v < numCourses; v++) {
      Deque<Integer> stack = new ArrayDeque<>();
      
      stack.push(v);

      while(!stack.isEmpty()) {
        int node = stack.peek();
      
        List<Integer> edges = graph.get(node);

        if (edges.size() > 0) {
          for(int w : edges) {
            if (stack.contains(w))
              return false;
      
            stack.push(w);
            edges.remove(Integer.valueOf(w));
            break;
          }
        } else {
          stack.pop();
        }
      }
    }

    return true;
  }
  */
}
